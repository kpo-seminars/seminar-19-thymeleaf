package ru.hse.seminar19thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class Seminar19ThymeleafApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ronreiter-meme-generator.p.rapidapi.com/images"))
                .header("X-RapidAPI-Key", "4b21733326msh38e3544644f78fap1ca95djsn70f77e05047e")
                .header("X-RapidAPI-Host", "ronreiter-meme-generator.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        SpringApplication.run(Seminar19ThymeleafApplication.class, args);
    }

}
