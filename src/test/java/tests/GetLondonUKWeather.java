package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetLondonUKWeather {
    @BeforeAll
    public static void setup() {
        baseURI = "http://api.openweathermap.org/data/2.5";
    }

    @Test
    public void getLondonUKWeather_expectedLondonCity() {
        String city = "London";
        String countryCode = "uk";
        String appid = "7488f5cd3fbbc91c90332c7d4e0af61a";

        given()
                .queryParam("q", city + "," + countryCode)
                .queryParam("appid", appid)
        .when()
                .get("/weather")
        .then()
                .statusCode(200)
                .assertThat().body("name", equalTo(city))
        ;
    }
}
