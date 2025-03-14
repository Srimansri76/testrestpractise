package tests;


import io.restassured.RestAssured;
//import org.apache.log.Priority;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class practisingparams {


    @Test (priority = 1)
    public void practiseparams () {

   given().pathParams("basePath","users")
          // .queryParams("page",2)
           .queryParams("id",47)

           .when()
           .get("https://reqres.in/api/{basePath}")

           .then().log().all();


    }


   // @Test
    public void testingcomplication () {

        given()
                .pathParams("mypath","users")
                .queryParams("page",2)
                .queryParams("id",5)

                .when().get("https://reqres.in/api/{mypath}")
                .then().log().all();

    }





}


