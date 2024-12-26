package com.example.demo.services;

import com.example.demo.models.LoginUserModel;
import com.example.demo.models.TemporaryUser;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.TemporaryUserRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository uRepo;

    @Autowired
    JWTService jwtService;

    @Autowired
    TemporaryUserRepository tempRepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    EmailService emailService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public boolean registerEmailOnly(TemporaryUser user) {
        try {
            UserModel userModel = new UserModel();
            userModel.set_id(user.get_id());
            uRepo.save(userModel);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public Boolean registerUser(UserModel user) {
        try{
            System.out.println(user);
            if(uRepo.findUserBy_id(user.get_id()) != null) {
                System.out.println(user);
                user.setPassword(encoder.encode(user.getPassword()));
                System.out.println(user);
                uRepo.save(user);
                return true;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public Boolean generateOtpAndSendEmail(TemporaryUser tempUser){
        String otp = emailService.generateOtp();
        try{
            if(otp != null){
                emailService.sendOtpEmail(tempUser.get_id(),otp);
                tempUser.setOtp(otp);
                tempRepo.save(tempUser);
                return true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public boolean verifyOtp(TemporaryUser tempUser) {
        try{
            TemporaryUser savedUser = tempRepo.findTemporaryUserBy_id(tempUser.get_id());
            if(savedUser != null){
                System.out.println(savedUser.getOtp() + "  " +tempUser.getOtp());
                return savedUser.getOtp().equals(tempUser.getOtp());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    public List<UserModel> getUsers() {
        return uRepo.findAll();
    }

    public UserModel getUserByEmail(String email) {
        try{
            System.out.println(email);
            UserModel user = uRepo.findUserBy_id(email);
            return new UserModel(user.get_id(),user.getEmail(),user.getName(),"");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String verifyUser(LoginUserModel user) {

        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.get_id(),user.getPassword()));

        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        }
        return "Fail";

    }
}
