import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.User;

import com.example.demo.dto.JwtResult;

import com.example.demo.service.UserService;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expirationTime;

    public String generateToken(User user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean validateToken(String token, User user) {
        try {
            if (user == null || token.isEmpty()) {
                return false;
            }

            final String userId = extractUserId(token);
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

    public String extractUserId(String token) {
        Claims claims = extractAllClaims(token);

        if (claims == null) {
            return null;
        }

        return (String) claims.get("id");
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
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            return null;
        }
    }

    public JwtResult parseRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String userId = extractUserId(token);

        if (userId == null) {
            return null;
        }

        User user = userService.getUserById(userId);
        JwtResult result = new JwtResult();
        result.setUser(user);
        result.setPassed(validateToken(token, user));

        return result;
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}