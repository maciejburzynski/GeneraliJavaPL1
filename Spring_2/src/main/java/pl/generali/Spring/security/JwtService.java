package pl.generali.Spring.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {


    public String generateToken(HttpServletResponse response) {
        Algorithm algorithm = Algorithm.HMAC256("kluczyk-byczQ");
        String token = JWT.create()
                .withSubject("generali-byczQ")
                .withClaim("permission", "nothing")
                .withExpiresAt(new Date(System.currentTimeMillis() + (10 * 60 * 1000))) // 10 minutes
                .sign(algorithm);
        response.addHeader("jwt-auth-generali", token);
        return token;
    }
}
