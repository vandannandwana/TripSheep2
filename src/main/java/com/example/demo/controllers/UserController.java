package com.example.demo.controllers;

import com.example.demo.models.*;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService uService;


    @PostMapping("/otpsend")
    public MessageResponse otpSend(@RequestBody TemporaryUser tempUser) {
        tempUser.set_id(tempUser.getEmail());
        if(uService.generateOtpAndSendEmail(tempUser)){
            return new MessageResponse("OTP Send Successful");
        }else{
            return new MessageResponse("OTP Send Failed");
        }
    }

    @PostMapping("/verifyotp")
    public MessageResponse verifyOtp(@RequestBody TemporaryUser tempUser) {
        tempUser.set_id(tempUser.getEmail());
        if(uService.verifyOtp(tempUser)){
            uService.registerEmailOnly(tempUser);
            return new MessageResponse("OTP Verify Successful");
        }else {
            return new MessageResponse("OTP Verify Failed");
        }
    }

    @PostMapping("/registeruser")
    public MessageResponse register(@RequestBody UserModel user) {
        user.set_id(user.getEmail());
        if(uService.registerUser(user)){
            System.out.println(user);
            return new MessageResponse("User Registered Successfully");
        }else {
            return new MessageResponse("User Register Failed");
        }

    }

    @PostMapping("/getUser")
    public UserModel getUser(@RequestBody TemporaryUser user) {
        System.out.println(user);
        user.set_id(user.getEmail());
        return uService.getUserByEmail(user.get_id());

    }

    @GetMapping("/getUsers")
    public List<UserModel> getAllUsers() {
        return uService.getUsers();

    }

    @PostMapping("/loginuser")
    public JwtToken login(@RequestBody LoginUserModel user) {
        user.set_id(user.getEmail());
        JwtToken token = new JwtToken();
        token.setToken(uService.verifyUser(user));
        return token;

    }

}
