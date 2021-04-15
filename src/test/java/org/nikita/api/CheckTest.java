package org.nikita.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.nikita.api.model.ResponseError;
import org.nikita.api.model.ResponseIpAddress;

public class CheckTest {
    private final static String BASE_PATH = "check";
    private final static String GOOGLE_IP = "216.58.215.78";
    private final static String PRIVATE_IP = "192.168.0.1";
    private final static String INVALID_IP = "216.0.0.300";
    private final static String INVALID_IP_ERROR_MESSAGE = "The ip address must be a valid IPv4 or IPv6 address (e.g. 8.8.8.8 or 2001:4860:4860::8888).";

    /**
     * AIPDB-1.1
     */
    @Test
    public void testCheckIpAddressDataSuccessfullyWithPublicIp() {
        ResponseIpAddress responseIpAddress = given()
            .param("ipAddress", GOOGLE_IP)
            .get()
            .then()
            .statusCode(200)
            .extract()
            .as(ResponseIpAddress.class);

        Assertions.assertEquals(GOOGLE_IP, responseIpAddress.getData().getIpAddress());
        Assertions.assertTrue(responseIpAddress.getData().isPublic());
    }

    /**
     * AIPDB-1.2
     */
    @Test
    public void testCheckIpAddressDataSuccessfullyWithPrivateIp() {
        ResponseIpAddress responseIpAddress = given()
            .param("ipAddress", PRIVATE_IP)
            .get()
            .then()
            .statusCode(200)
            .extract()
            .as(ResponseIpAddress.class);

        Assertions.assertEquals(PRIVATE_IP, responseIpAddress.getData().getIpAddress());
        Assertions.assertFalse(responseIpAddress.getData().isPublic());
    }

    /**
     * AIPDB-1.3
     */
    @Test
    public void testCheckIpAddressDataUnsuccessfullyWithInvalidIp() {
        ResponseError errors = given()
            .param("ipAddress", INVALID_IP)
            .get()
            .then()
            .statusCode(422)
            .extract()
            .as(ResponseError.class);

        Assertions.assertEquals(1, errors.getErrors().length);
        Assertions.assertEquals(INVALID_IP_ERROR_MESSAGE, errors.getErrors()[0].getDetail());
    }

    private RequestSpecification given() {
        return RestAssured
            .given()
            .spec(BaseRequestSpecification.given())
            .basePath(BASE_PATH);
    }
}
