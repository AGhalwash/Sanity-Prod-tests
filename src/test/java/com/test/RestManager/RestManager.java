package com.test.RestManager;


import com.stacks.bdd.constants.core.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Map;


public final class RestManager {

    private RestManager() {

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

}

