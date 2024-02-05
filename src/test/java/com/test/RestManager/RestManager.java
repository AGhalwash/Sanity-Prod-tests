package com.test.RestManager;


import com.stacks.bdd.constants.core.Constants;
import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;


public final class RestManager {

    public RestManager(CustomWebDriver driver) {

    }

    static Logger logger = Logger.getLogger(RestManager.class.getName());


    public static RequestSpecification setupRequestWithToken( String url) {
        RequestSpecification requestSpec = RestAssured.with();
        requestSpec.given().header("Accept-Language", "fr").contentType("application/json");
        requestSpec.headers("Authorization", "Bearer ");
        requestSpec.baseUri(url);
        return requestSpec;
    }

    public static RequestSpecification setupRequestWithTokenForPostAndDelete(String token, String url) {
        RequestSpecification requestSpec = RestAssured.with();
        requestSpec.given().contentType("application/x-www-form-urlencoded");
        requestSpec.headers("Authorization", "Bearer " + token);
        requestSpec.baseUri(url);
        return requestSpec;
    }

    public static RequestSpecification setupRequestWithTokenForPatch(String token, String url, String body) {
        RequestSpecification requestSpec = RestAssured.with();
        requestSpec.given().contentType("application/json");
        requestSpec.headers("Authorization", "Bearer " + token);
        requestSpec.body(body);
        requestSpec.baseUri(url);
        return requestSpec;
    }


    public static Response sendRequestByMethod(RequestSpecification request, String opType, String serviceURL) {
        Response response;
        switch (opType.toUpperCase()) {
            case "GET":
                response = request.when().get(serviceURL);
                break;
            case "POST":
                response = request.when().post(serviceURL);
                break;
            case "PUT":
                response = request.when().put(serviceURL);
                break;
            case "PATCH":
                response = request.when().patch(serviceURL);
                break;
            case "DELETE":
                response = request.when().delete(serviceURL);
                break;
            default:
                throw new IllegalArgumentException(opType + Constants.NOT_FOUND);
        }
        return response;
    }


    public static Response getResponseWithOutBody(  String url, String opType) throws IOException {
        RequestSpecification requestSpecification = setupRequestWithToken( url);
        Response response = sendRequestByMethod(requestSpecification,opType,url);
        return response;
    }


    public static Response getResponseParam(String url, String opType, org.json.simple.JSONObject body) throws IOException {
        RequestSpecification requestSpecification = setupRequestWithToken( url);
        for (Map.Entry<String, Object> paramEntry : ((Map<String, Object>)body).entrySet()) {
            requestSpecification.param(paramEntry.getKey(), paramEntry.getValue());
        }
        Response response = sendRequestByMethod(requestSpecification,opType,url);
        return response;
    }

    public static Response getResponseQueryParam(String accessToken, String url, String opType, org.json.simple.JSONObject body) throws IOException {
        RequestSpecification requestSpecification = setupRequestWithTokenForPostAndDelete(accessToken, url);
        for (Map.Entry<String, Object> paramEntry : ((Map<String, Object>)body).entrySet()) {
            requestSpecification.queryParam(paramEntry.getKey(), paramEntry.getValue());
        }
        Response response = sendRequestByMethod(requestSpecification,opType,url);
        return response;
    }

    public static Response getResponseQueryParamAndBody(String accessToken, String url, String opType, org.json.simple.JSONObject body, String innerbody) throws IOException {
        RequestSpecification requestSpecification = setupRequestWithTokenForPatch(accessToken, url, innerbody);
        for (Map.Entry<String, Object> paramEntry : ((Map<String, Object>)body).entrySet()) {
            requestSpecification.queryParam(paramEntry.getKey(), paramEntry.getValue());
        }
        Response response = sendRequestByMethod(requestSpecification,opType,url);
        return response;
    }

    public String getAccessToken() {
        String accessToken = null;
        String requestBody = "{" +
                "\"grant_type\": \"password\"," +
                "\"username\": \"auto.superadmin01@ashour.com\"," +
                "\"password\": \"1234512345ab\"," +
                "\"audience\": \"https://alefed.com/backend\"," +
                "\"scope\": \"openid profile email\"," +
                "\"client_id\": \"2L8g2yDFThx0Qety6RcLnAJxYQWcKoUJ\"," +
                "\"client_secret\": \"7Eb85Vt992mr8HtrkkzNsY-B9HW2nHq2CrnNvCU90guyVkxU0h_XSKSvRn5rQ1wT\"" +
                "}";

        Response response = given().contentType("application/json")
                .body(requestBody)
                .when().post("https://alef-jackals.eu.auth0.com/oauth/token");

        // Print the response content for debugging
        System.out.println("Response Content: " + response.getBody().asString());

        if (response.getStatusCode() == 200) {
            accessToken = response.then().extract().path("access_token");
            System.out.println("access_token: " + response.getBody().asString());
        } else {
            System.out.println("Error Response: " + response.getBody().asString());
            // Implement error handling logic if needed
        }

        return accessToken;
    }

}

