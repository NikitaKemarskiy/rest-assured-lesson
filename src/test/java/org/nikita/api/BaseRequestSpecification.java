package org.nikita.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.nikita.config.Config;

public class BaseRequestSpecification {
    public static RequestSpecification given() {
        return RestAssured.given()
            .baseUri(Config.getProperty("apiBaseUrl"))
            .header("Key", Config.getProperty("apiKey"))
            .accept("application/json");
    }
}
