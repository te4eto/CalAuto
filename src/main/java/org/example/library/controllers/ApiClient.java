package org.example.library.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.example.library.authorization.AuthManager;
import org.example.library.customObjects.CustomResponse;
import org.example.library.customObjects.ResponseWrapper;
import org.example.library.models.general.Configuration;

import java.util.List;

import static io.restassured.RestAssured.given;

public abstract class ApiClient {
    private final String authorizationToken;
    private RequestSpecification requestSpecification;
    private static final ObjectMapper objectMapper = createDefaultObjectMapper();

    public ApiClient() {
        this.authorizationToken = AuthManager.getToken();
        buildRequest();
        setUrlEncoding(false);
    }

    private static ObjectMapper createDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }

    protected CustomResponse sendRequest(String url, RequestType requestType, Object... requestBody) throws JsonProcessingException {
        Response response = handleRequest(url, requestType, requestBody);
        return new CustomResponse(response);
    }

    protected <T> ResponseWrapper<T> sendRequest(String url, RequestType requestType, Class<T> responseType, Object... requestBody) throws JsonProcessingException {
        Response response = handleRequest(url, requestType, requestBody);
        return mapResponse(response, responseType);
    }

    private Response handleRequest(String url, RequestType requestType, Object... requestBody) throws JsonProcessingException {
        if (requestBody.length > 0 && requestType != RequestType.GET) {
            Object bodyObject = requestBody[0];
            requestSpecification.body(
                    bodyObject instanceof String ?
                            (String) bodyObject :
                            toJson(bodyObject)
            ).contentType(ContentType.JSON);
        }

        Response response = switch (requestType) {
            case GET -> requestSpecification.get(url);
            case POST -> requestSpecification.post(url);
            case PUT -> requestSpecification.put(url);
            case PATCH -> requestSpecification.patch(url);
            case DELETE -> requestSpecification.delete(url);
        };

        buildRequest();
        return response;
    }

    private <T> ResponseWrapper<T> mapResponse(Response response, Class<T> responseType) throws JsonProcessingException {
        String jsonString = response.body().asString();

//        if (isErrorResponse(jsonString)) {
//            return mapErrorResponse(response, jsonString);
//        }

        if (isListResponse(jsonString)) {
            return mapListResponse(response, jsonString, responseType);
        }

        return mapObjectResponse(response, jsonString, responseType);
    }

    private boolean isErrorResponse(String jsonString) {
        return StringUtils.isEmpty(jsonString) || jsonString.contains("error");
    }

    private boolean isListResponse(String jsonString) {
        return jsonString.trim().startsWith("[");
    }

    private <T> ResponseWrapper<T> mapErrorResponse(Response response, String jsonString) {
        return new ResponseWrapper<>(new CustomResponse(response), jsonString);
    }

    private <T> ResponseWrapper<T> mapListResponse(Response response, String jsonString, Class<T> responseType) throws JsonProcessingException {
        JavaType listType = objectMapper.getTypeFactory().constructCollectionType(List.class, responseType);
        List<T> responseList = objectMapper.readValue(jsonString, listType);
        return new ResponseWrapper<>(new CustomResponse(response), responseList);
    }

    private <T> ResponseWrapper<T> mapObjectResponse(Response response, String jsonString, Class<T> responseType) throws JsonProcessingException {
        T responseObject = objectMapper.readValue(jsonString, responseType);
        return new ResponseWrapper<>(new CustomResponse(response), responseObject);
    }

    private void buildRequest() {
        RestAssured.useRelaxedHTTPSValidation();

        requestSpecification = given()
                .baseUri(Configuration.getBaseUrl());


        //example of token/cookie setting based on env
        if (Configuration.getEnvironmentValue().equals("CLOUD")) {
            requestSpecification.header("Authorization", "Bearer " + authorizationToken);
        } else if (Configuration.getEnvironmentValue().equals("LOCAL")) {
            requestSpecification.header("Cookie", authorizationToken);
        }
    }

    private static String toJson(Object requestModel) throws JsonProcessingException {
        return objectMapper.writeValueAsString(requestModel);
    }

    protected void setUrlEncoding(boolean value) {
        requestSpecification.urlEncodingEnabled(value);
    }

    protected void setQueryParam(String key, Object value){
        requestSpecification.queryParam(key, value);
    }

    protected void setHeader(String key, Object value){
        requestSpecification.header(key, value);
    }
}
