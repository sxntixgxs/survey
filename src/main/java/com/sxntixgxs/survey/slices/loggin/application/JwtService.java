package com.sxntixgxs.survey.slices.loggin.application;

import java.util.HashMap;

@Service
public class JwtService {
    public String getToken(UserDetails user){
        return getToken(new HashMap<>(),user);
    }
    private String getToken(Map<Sring,Object> extraClaims, UserDetails user){
        return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMilis()))
            .setExpiration(new Date(System.currentTimeMilis()+1000*60*4))
            .signWith(getKey(),SignatureAlgorithm.H256)
            .compact();
    }
    private Key getKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
