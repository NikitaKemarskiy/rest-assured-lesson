package org.nikita.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nikita.api.model.ResponseClearAddress;

public class ClearAddressTest {
    private final static String BASE_PATH = "clear-address";
    private final static String GOOGLE_IP = "216.58.215.78";

    /**
     * AIPDB-1.4
     */
    @Test
    public void testClearIpAddressRecordSuccessfullyWithPublicIp() {
        ResponseClearAddress responseClearAddress = given()
            .param("ipAddress", GOOGLE_IP)
            .delete()
            .then()
            .statusCode(200)
            .extract()
            .as(ResponseClearAddress.class);

        Assertions.assertEquals(0, responseClearAddress.getData().getNumReportsDeleted());
    }

    private RequestSpecification given() {
        return RestAssured
            .given()
            .spec(BaseRequestSpecification.given())
            .basePath(BASE_PATH);
    }
}
