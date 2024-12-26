package com.example.demo.services;

import com.example.demo.models.LoginUserModel;
import com.example.demo.models.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secret_key="";

    JWTService(){
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
            secret_key = Base64.getEncoder().encodeToString(keygen.generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public String generateToken(LoginUserModel user) {

        Map<String,Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.get_id())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + (60 * 60 *30)))
                .and()
                .signWith(getKey())
                .compact();


    }

    private Key getKey() {

        byte[] keyBytes = Decoders.BASE64.decode(secret_key);

        return Keys.hmacShaKeyFor(keyBytes);

    }
}
