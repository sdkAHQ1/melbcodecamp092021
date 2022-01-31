package com.accesshq.apitests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class ApiTestSuite {

    @Test
    public void TestStatus() {
        given().
                param("q", "Tascott").and().header("auth-key", "c912db24-d4be-4303-97ff-92f940a58b8b").
        when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
                assertThat().statusCode(200);
    }

    @Test
    public void TestPostcode() {
        given().
                param("q", "Tascott").and().header("auth-key", "c912db24-d4be-4303-97ff-92f940a58b8b").
        when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
                assertThat().statusCode(200).and().assertThat().body("localities.locality.postcode",equalTo(2250));
    }
}
