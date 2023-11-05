package com.solutioncode.scrum.component.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtManager {

    public static Logger logger = LoggerFactory.getLogger(JwtManager.class);
    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expire}")
    private int HOUR;

    private final Calendar calendar = Calendar.getInstance();

    public String generateJwt(String sub, String name, String email) {
        var issueAt = new Date();
        var expiration = expireDate(issueAt);
        return Jwts.builder()
                .issuedAt(issueAt)
                .expiration(expiration)
                .claim("sub", sub)
                .claim("name", name)
                .claim("email", email)
                .signWith(getSigningKey())
                .compact();
    }

    private Date expireDate(Date now) {
        calendar.setTime(now);
        calendar.add(Calendar.HOUR, this.HOUR);
        return calendar.getTime();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = this.SECRET.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
            return true;
        } catch (ExpiredJwtException ex) {
            logger.error("JWT expired: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            logger.error("Token is null, empty or only whitespace: " + ex.getMessage());
        } catch (MalformedJwtException ex) {
            logger.error("JWT is invalid: " + ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            logger.error("JWT is not supported: " + ex.getMessage());
        } catch (SignatureException ex) {
            logger.error("Signature validation failed");
        }
        return false;
    }

    public Claims parseClaims(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
