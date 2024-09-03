package com.sxntixgxs.survey.jwt.application;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.auth.domain.User;
import com.sxntixgxs.survey.auth.domain.ports.out.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service("jwtServiceAuth")
public class JwtService {
    private static final String SECRET_KEY="BZYioPJ7T9/xVgeXm+eNznGAsjxHVcaG+1xwChpjgFc=";
    private final UserRepository userRepository;
    
    public JwtService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String getToken(UserDetails user) {
        return getToken(new HashMap<>(), user);
    }
    public String getToken(Map<String,Object> extraClaims, UserDetails user){
        extraClaims.put("roles", user.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .map(authority -> authority.replace("ROLE_",""))
            .collect(Collectors.toList()));
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
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parserBuilder().setSigningKey(getKey()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("user not found"));
        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            .authorities(user.getAuthorities())
            .build();
    }


}
