package com.example;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class JsonPlaceholderApi {

    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/";
    private final String resourcePath;
    private Response response;

    public JsonPlaceholderApi(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public Response get() {
        response = given().get(ENDPOINT + resourcePath);
        return response;
    }

    public int getStatusCode() {
        return response == null ? 0 : response.getStatusCode();
    }

    public String getBody() {
        return response == null ? null : response.body().prettyPrint();
    }

    public String getHeaders() {
        return response == null ? null : response.headers().toString();
    }

    public String getFullResponse() {
        return getFullResponse(false);
    }

    public String getFullResponse(boolean maskDynamicContent) {
        String fullResponse = getHeaders() + "\n\n" + getBody();

        if (maskDynamicContent) {
            fullResponse = fullResponse.replaceAll("Date=.*", "#####DATE");
            fullResponse = fullResponse.replaceAll("Set-Cookie=.*", "#####COOKIE");
            fullResponse = fullResponse.replaceAll("CF-RAY=.*", "#####CF-RAY");
        }

        return fullResponse;
    }
}
