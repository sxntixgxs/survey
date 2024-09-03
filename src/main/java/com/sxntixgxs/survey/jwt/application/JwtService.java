package com.sxntixgxs.survey.jwt.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service("jwtServiceAuth")
public class JwtService {
    private static final String SECRET_KEY="BZYioPJ7T9/xVgeXm+eNznGAsjxHVcaG+1xwChpjgFc=";
    
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }
    public String getToken(Map<String,Object> extraClaims, UserDetails user){
        return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))//+1 dia
            .signWith(getKey(),SignatureAlgorithm.HS256)
            .compact();
    }
    private Key getKey(){
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
