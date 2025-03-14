package tests.practisechaining;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class createproduct {

   @Test
    public void creatinguser(){

Faker faker = new Faker();


       JsonObject innerdata = new JsonObject();
       innerdata.addProperty("year","2005");
       innerdata.addProperty("price",faker.number().randomDigitNotZero());
       innerdata.addProperty("CPU model",faker.company().name());
       innerdata.addProperty("Hard disk size","9 TB");



       JsonObject data = new JsonObject();
       data.addProperty("name",faker.name().firstName());
       data.add("data",innerdata);



       given()
               .header("Content-Type","application/json")
               .body(data.toString())

               .when().post("https://api.restful-api.dev/objects")

               .then().statusCode(200)
               .log().all();
   }
}
