package org.example.library.authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.library.models.general.Configuration;

import static io.restassured.RestAssured.given;

public class PoCFetcher {

    public static String getBearerToken(){
        var clientId = Configuration.getClientId();
        var clientSecret = Configuration.getClientSecret();
        var baseUri = Configuration.getBaseUrl();

        return performLogin(baseUri, clientId, clientSecret);
    }

    public static String performLogin(String baseUri, String clientId, String clientSecret) {
        var endpoint = "/ext/keycloak/realms/CALsuite/protocol/openid-connect/token";
        RestAssured.baseURI = baseUri;

        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .formParam("grant_type", "client_credentials")
                .post(endpoint);

        String accessToken = response.jsonPath().getString("access_token").trim();

        if (accessToken == null) {
            throw new RuntimeException("Failed to obtain access token");
        }

        return accessToken;
    }
}
