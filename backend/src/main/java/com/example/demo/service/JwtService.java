package com.example.demo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;
import javax.crypto.SecretKey;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import jakarta.annotation.PostConstruct;

import com.example.demo.model.User;

import com.example.demo.dto.JwtResult;

import com.example.demo.repository.UserRepository;

import java.util.Date;
import java.util.function.Function;
import java.util.Optional;

@Component
public class JwtService {

    private SecretKey key;
    
    @Autowired
    private UserRepository userRepository;
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private Long expirationTime;

    @PostConstruct
    public void init() {
        byte[] secretBytes = secret.getBytes(StandardCharsets.UTF_8);
        key = Keys.hmacShaKeyFor(secretBytes);
    
    }

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * 1000))
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token, User user) {
        try {
            if (user == null || token.isEmpty()) {
                return false;
            }

            final Integer userId = extractUserId(token);
            return (userId != null && userId.equals(user.getId()) && !isTokenExpired(token));
        } catch (SignatureException e) {
            return false;
        }
    }

    public String extractUserMail(String token) {
        Claims claims = extractAllClaims(token);

        if (claims == null) {
            return null;
        }

        return (String) claims.get("email");
    }

    public Integer extractUserId(String token) {
        Claims claims = extractAllClaims(token);

        if (claims == null) {
            return null;
        }

        return (Integer) claims.get("id");
    }

    public String extractUserName(String token) {
        Claims claims = extractAllClaims(token);

        if (claims == null) {
            return null;
        }

        return (String) claims.get("name");
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);

        if (claims == null) {
            return null;
        }

        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            return null;
        }
    }

    public JwtResult parseRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
    
        Integer userId = extractUserId(token);
    
        if (userId == null) {
            return null;
        }

        User user = null;
        Optional<User> OptionalUser = userRepository.findById(userId);

        if (!OptionalUser.isPresent()) {
            return null;
        } else {
            user = OptionalUser.get();
        }

        JwtResult result = new JwtResult();
        result.setUser(user);
        result.setUser_id(userId);
        result.setPassed(validateToken(token, user));

        return result;
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}