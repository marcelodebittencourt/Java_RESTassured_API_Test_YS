package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class GetLondonUKWeather {
    @Test
    public void getLondonUKWeather_expectedLondonCity() {
        when().
                get("http://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=7488f5cd3fbbc91c90332c7d4e0af61a").
        then().
                statusCode(200);
    }
}
