package tests;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class sdetpavanstyle4 {

    int id;
    // its global variable for storing the any values ( put , post , delete opertaions )

    @Test(priority = 1)
    public void GetUserDetails () {

        given()

                .when().get("https://reqres.in/api/users?page=2")

                .then().statusCode(200).log().all();

    }



    @Test (priority = 2)

    public void CreateNewUser () {

        Map data = new HashMap();
        data.put("Name","SDET4");
        data.put("Job","Student");

       id = given()
                 .contentType("application/json").body(data)

                 .when()
                 .post("https://reqres.in/api/users")
                 .jsonPath().getInt("id");

    }


    @Test (priority = 3 , dependsOnMethods = {"CreateNewUser"})

    public void UpadteUser () {

        Map data = new HashMap();
        data.put("Name", "SDE4");
        data.put("Job", "QA Engineer");

        given()
                .contentType("application/json").body(data)

                .when()
                .put("https://reqres.in/api/users" + id)

                .then().log().all();



    }

    @Test (priority = 4)

            public void DeleteUser () {
        given()

                .when().delete("https://reqres.in/api/users" + id)

                .then().statusCode(204).log().all();

    }

}