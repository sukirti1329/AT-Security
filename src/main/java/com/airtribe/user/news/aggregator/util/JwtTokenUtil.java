package com.airtribe.user.news.aggregator.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationMs = 3600000; // 1 hour

    public static boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }

    }

//    public static void validateToken(String token) {
//        Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token); // Throws an exception if invalid
//    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
