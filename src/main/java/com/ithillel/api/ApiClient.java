package com.ithillel.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithillel.utils.ConfigProvider;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matcher;


import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.isIn;


@Slf4j
public class ApiClient {

    public static final Matcher<Integer> SUCCESS = isIn(asList(200, 201, 202, 204));
    public static final Matcher<Integer> CLIENT_ERROR = isIn(asList(400, 401, 403, 404));


    private final String apiUrl = ConfigProvider.API_URL;
    private final int apiPort = ConfigProvider.API_PORT;
    private final String apiUser = ConfigProvider.API_USER;
    private final String apiPassword = ConfigProvider.API_PASSWORD;
    private final RequestSpecification requestSpec;


    public ApiClient() {
//        ObjectMapper objectMapper = new ObjectMapper();
//       objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//       objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        RestAssuredConfig config = RestAssuredConfig.config()
//                .objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory((type, s) -> objectMapper));
        if (log.isDebugEnabled()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(apiUrl)
                .setPort(apiPort)
                // .setConfig(config)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .build();
        login();
    }

    public RequestSpecification request() {
        return given().spec(requestSpec);
    }

    private void login() {
        String sessionId = request().contentType(ContentType.URLENC)
                .body(format("username=%s&password=%s", apiUser, apiPassword))
                .post("/login")
                .sessionId();
        requestSpec.sessionId(sessionId);
    }

    public JsonPath get(String endpoint) {
        return request()
                .get(endpoint)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .body()
                .jsonPath();
    }

    public JsonPath post(String endpoint, Object body) {

        return request()
                .body(body)
                .post(endpoint)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .body()
                .jsonPath();
    }


    public JsonPath put(String endpoint, Object body) {
        return request()
                .body(body)
                .put(endpoint)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .body()
                .jsonPath();
    }

    public JsonPath delete(String endpoint) {
        return request()
                .delete(endpoint)
                .then()
                .statusCode(SUCCESS)
                .extract()
                .body()
                .jsonPath();
    }

    public String getNonExistent(String endpoint) {
        return request()
                .get(endpoint)
                .then()
                .statusCode(404)
                .extract()
                .body()
                .asPrettyString();
    }
}