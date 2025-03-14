package tests.practisechaining;

import com.google.gson.JsonObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class updateproduct {

    @Test
    public void updateuserdetailsbasedonid(ITestContext context){

        String id = (String) context.getAttribute("product_id");

        System.out.println("Getting  ID: " + id);

        JsonObject innerdata = new JsonObject();
        innerdata.addProperty("year",1976);
        innerdata.addProperty("price", 100);
        innerdata.addProperty("CPU model","updatedcompany");
        innerdata.addProperty("Hard disk size","76 TB");

        JsonObject data = new JsonObject();
        data.addProperty("name", "Updated Name");
        data.add("data", innerdata);

        given()
                .header("Content-Type", "application/json")  // Required header
                .body(data.toString())
                .when().put("https://api.restful-api.dev/objects/"+id)
                .then().statusCode(200)
                .body("data.year" , equalTo(1976))
        .log().all();


    }
}
