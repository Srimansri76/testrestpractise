package tests.practisechaining;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class createproduct {

    @Test
    public void creatinguser(ITestContext context) {
        Faker faker = new Faker();

        JsonObject innerdata = new JsonObject();
        innerdata.addProperty("year", "2005");
        innerdata.addProperty("price", faker.number().randomDigitNotZero());
        innerdata.addProperty("CPU model", faker.company().name());
        innerdata.addProperty("Hard disk size", "9 TB");

        JsonObject data = new JsonObject();
        data.addProperty("name", faker.name().firstName());
        data.add("data", innerdata);

        // Capture the full response
        String responseBody = given()
                .header("Content-Type", "application/json")
                .body(data.toString())
                .when()
                .post("https://api.restful-api.dev/objects")
                .then()
                .log().body()  // Logs the full response body for debugging
                .extract().asString();

        System.out.println("Full Response: " + responseBody);

        // Extract ID correctly
        String id = given()
                .header("Content-Type", "application/json")
                .body(data.toString())
                .when()
                .post("https://api.restful-api.dev/objects")
                .jsonPath().getString("id");

        System.out.println("Generated ID (RestAssured): " + id);

        context.setAttribute("product_id", id);
    }
}