package com.App.Yogesh.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {

    // Generate a secure key that meets the required 256-bit length
    private static final SecretKey key =Keys.hmacShaKeyFor(jwtConstant.SECRET_KEY.getBytes());

    public static String generateToken(Authentication auth) {
        String jwt = Jwts.builder()
                .setIssuer("Yogesh").setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+ 3600000))
                .claim("email",auth.getName())
                .signWith(key)
                .compact();
        return jwt;
    }

    public static String getEmailFromJwtToken(String jwt) {

        jwt = jwt.substring(7); // Assuming "Bearer " prefix
        Claims claims = Jwts.parserBuilder()
                .parserBuiler()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        return String.valueOf(claims.get("email"));
    }
}
