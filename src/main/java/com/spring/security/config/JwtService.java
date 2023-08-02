package com.spring.security.config;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "npNjBMkNQH0Q8PKCMBjpRVx0jsbuQpsfvD32fCIF9CAtC8A97JebQtUYO0rGGZ6RVeAyXD5hcRTAf8y20D7At80lAUWf37rNt5nIoWCzrJCEtlQyWZfngE902OeIL8k2lCqn+aiXQn1jw92gVQGcUP+g4+Y9TyeeRCcvdZI6Ltfb/t4ZUGFBzkwz99AKEOvt/o0S1AiOxdGrGMJ8Tf5fQWeSXj10wHzyrJXNxIpAZBkHBocucYHdMRWJBiCa9tWabJmapp28EJhXbCfa7AgosI0t4o5DFEZ4vJKhyvTsnR8ou+vNttsx8RzEearQCnvfTFmGmGjQSlNX3e4dfxQxE55S1QunTd3yzCTxNWK69Zk";

    public String extractUsername(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignIngKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignIngKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
