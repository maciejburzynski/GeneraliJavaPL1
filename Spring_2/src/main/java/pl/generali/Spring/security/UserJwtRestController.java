package pl.generali.Spring.security;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserJwtRestController {

    private final JwtService jwtService;

    @GetMapping("api/token")
    String getToken(HttpServletResponse response) {
        return jwtService.generateToken(response);
    }
}
