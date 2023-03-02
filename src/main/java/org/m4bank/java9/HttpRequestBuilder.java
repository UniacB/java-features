package org.m4bank.java9;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@SuppressWarnings("unused")
public final class HttpRequestBuilder {

    private HttpRequestBuilder() {
    }

    public static void sendRequestAndPrintResponse() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/get"))
                .version(java.net.http.HttpClient.Version.HTTP_2)
                .header("test", "test")
                .GET()
                .timeout(Duration.of(30, SECONDS))
                .build();

        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code " + response.statusCode());
        System.out.println(response.body());
    }
}
