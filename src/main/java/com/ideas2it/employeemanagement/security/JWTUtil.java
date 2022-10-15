package com.ideas2it.employeemanagement.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {
    private String secret = "secret";

    public String extractUserId(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String,Object> tokenRequests = new HashMap<>();
        return createToken(tokenRequests, userDetails.getUsername());    }

    private String createToken(Map<String, Object> tokenRequests, String username) {
        return Jwts.builder().setClaims(tokenRequests).setSubject(username)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    /*public String extractUserIdFromToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User Details")
                .withIssuer("employeemanagement/ideas2itE")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("id").asString();
    }*/

    public boolean validateToken(String token, UserDetails userDetails) {
        return true;
    }
}
