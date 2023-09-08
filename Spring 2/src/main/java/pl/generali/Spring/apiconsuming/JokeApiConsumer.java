package pl.generali.Spring.apiconsuming;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.generali.Spring.apiconsuming.Joke;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.*;

@Service
@Slf4j
public class JokeApiConsumer {


    public Joke getRandomJoke() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(create("https://official-joke-api.appspot.com/random_joke"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        Joke jokeFromResponse = objectMapper.readValue(httpResponse.body().toString(), Joke.class);
        log.info("Punchline: {}", jokeFromResponse.getPunchline());
        return jokeFromResponse;
    }
}
