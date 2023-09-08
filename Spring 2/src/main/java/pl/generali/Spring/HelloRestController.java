package pl.generali.Spring;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HelloRestController {

    private final JokeApiConsumer jokeApiConsumer;

    @GetMapping(path = "/hello")
    public ResponseEntity<String> getHelloMessage(HttpServletResponse httpServletResponse,
                                                  HttpServletRequest httpServletRequest) {
        log.info("Displaying hello world...");
        Cookie[] userCookies = httpServletRequest.getCookies();
        if (userCookies.length == 0) {
            log.info("User has no cookiers");
        } else {
            System.out.println("Sout is the best");
            log.info("User has some cookies");
        }

        Cookie cookie = new Cookie("auth-cookie", "value-auth-cookie");
        httpServletResponse.addCookie(cookie);
        httpServletResponse.addHeader("group-name", "generali-java-pl-1");

        return ResponseEntity
                .status(ACCEPTED)
                .body("Hello World");
    }


    @GetMapping("/api-consuming")
    public Joke getJoke() {
        try {
            return jokeApiConsumer.getRandomJoke();
        } catch (IOException e) {
            log.info("No i dupa");
            return new Joke();
        } catch (InterruptedException e) {
            log.info("No i dupa dupa");
            return new Joke();
        }
    }
}
