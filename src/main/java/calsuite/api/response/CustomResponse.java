package calsuite.api.response;

import io.restassured.response.Response;

public class CustomResponse {
    private final Response response;

    public CustomResponse(Response response) {
        this.response = response;
    }

    public CustomResponse validateStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();

        if (actualStatusCode != expectedStatusCode) {
            String responseBody = response.getBody().asPrettyString();
            String errorMessage = String.format(
                    "Expected status code %d but got %d. Response body: %s",
                    expectedStatusCode, actualStatusCode, responseBody
            );

            throw new AssertionError(errorMessage);
        }

        return this;
    }

    public Response getOriginalResponse() {
        return response;
    }

    public String getBodyAsString() {
        return response.getBody().asString();
    }
}
