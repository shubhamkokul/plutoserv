package com.skokul.plutoserv.auth.service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.skokul.plutoserv.auth.model.JWTDataEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenManagement {
    private static final String EMAIL = "EMAIL";

    public String createJWTToken(JWTDataEntity entity, String secret) {
        Instant now = Instant.now();
        return Jwts.builder()
                .claim(EMAIL, entity.getEmail())
                .setSubject(entity.getUserId())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
                .signWith(getSecretKey(secret))
                .compact();
    }

    public JWTDataEntity getEmailFromToken(String jwtToken, String secret) {
        var body = getJWSClaims(jwtToken, secret).getBody();
        String email = body.get(EMAIL, String.class);
        String userId = body.getSubject();
        return new JWTDataEntity(email, userId);
    }

    private Jws<Claims> getJWSClaims(String jwtToken, String secret) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey(secret))
                .build()
                .parseClaimsJws(jwtToken);
    }

    private Key getSecretKey(String secret) {
        return new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());
    }
}
