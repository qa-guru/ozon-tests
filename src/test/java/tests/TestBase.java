package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://www.ozon.ru";
    }
}
