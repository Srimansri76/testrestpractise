package tests.practisechaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteproduct {


    @Test
    public void deleteproductbyid(ITestContext context){

        String id = (String) context.getAttribute("product_id");

        System.out.println("Getting  ID: " + id);

        given()
                .header("Content-Type", "application/json")  // Optional, but good practice
                .when()
                .delete("https://api.restful-api.dev/objects/" + id)
                .then()
                .statusCode(200)  // ✅ Use 204 if API returns "No Content"
                .log().all();
    }
}
