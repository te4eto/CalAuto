package org.example.library.controllers;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;

public class MiniEnvClient {

    public static void setupEnvironment() {
        Response response = buildRequest().put();
        assertThat(response.statusCode()).isBetween(200, 299);
    }

    private static RequestSpecification buildRequest() {
        RequestSpecification request =
                RestAssured.given()
                        .baseUri("http://mini-environment-manager.aut.nagel-group.calsuite")
                        .basePath("/environment/{id}/setup")
                        .pathParam("id", MINI_ENV_ID)
                        .queryParam("prefixTopicName", true)
                        .contentType(ContentType.MULTIPART)
                        .config(RestAssured.config()
                                .httpClient(HttpClientConfig.httpClientConfig()
                                        .setParam("http.connection.timeout", 600_000)
                                        .setParam("http.socket.timeout", 600_000)
                                )
                        );

        Files.list(Paths.get(BASE_STATE_LOCATION))
                .forEach(file ->
                        request.multiPart(
                                file.getFileName().toString().split("\\.")[0],
                                file.toFile()
                        )
                );

        Response setupResponse = request.put();
    }
}