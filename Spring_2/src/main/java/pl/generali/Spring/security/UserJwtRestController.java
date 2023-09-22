package pl.generali.Spring.security;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserJwtRestController {

    private final JwtService jwtService;

    @PostMapping("api/token")
    String getToken(@RequestBody AuthLoginRequest request, HttpServletResponse response) {
        return jwtService.generateToken(request, response);
    }
}
