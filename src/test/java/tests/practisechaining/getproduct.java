package tests.practisechaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getproduct {


    @Test
    public void gettingproductdetailsbasedonid (ITestContext context){



        String id = (String) context.getAttribute("product_id");

        System.out.println("Getting  ID: " + id);

        given().baseUri("https://api.restful-api.dev/objects/"+id)
                .when().get()
                .then().statusCode(200).log().all();
    }
}
