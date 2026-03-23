package org.webapp.splitit.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${jwt.base64-secret}")
    private String secret;
    @Value("${jwt.token-validity-seconds}")
    private long validity;

    public String generateToken(Authentication auth) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validity * 1000);

        return Jwts.builder()
                .setSubject(auth.getName())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)))
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(Decoders.BASE64.decode(secret))
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(Decoders.BASE64.decode(secret))
                    .build()
                    .parseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
