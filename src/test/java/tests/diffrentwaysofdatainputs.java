package tests;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.codehaus.groovy.util.ListHashMap;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class diffrentwaysofdatainputs {


        String emp;
       int emp1=2;


    @Test (priority = 1)
    public void testingtestng () {


        List<HashMap<String,String>> employees = new ArrayList<>();


       // 1st employee
        Map<String,String> data = new HashMap<>();
        data.put("email", "priya.sharma@example.com");
        data.put("first_name", "Priya");
        data.put("last_name", "Sharma");
        employees.add((HashMap<String, String>) data);

//       //2nd employee data
//        Map<String,String> data1 = new HashMap<>();
//        data1.put("email", "sakthi.sharma@example.com");
//        data1.put("first_name", "sakthi");
//        data1.put("last_name", "Roy");
//        employees.add((HashMap<String, String>)data1);
//
//        // 3rd employee
//
//        Map<String,String> data2 = new HashMap<>();
//        data2.put("email", "Bhumika.sharma@example.com");
//        data2.put("first_name", "Bhumika");
//        data2.put("last_name", "Sharma");
//        employees.add((HashMap<String, String>) data2);

for (Map<String , String> empData : employees )
  emp = String.valueOf(given().contentType("application/json")
               .pathParams("mypath", "users")
               .body(empData)

                .when().post("https://reqres.in/api/{mypath}")

                .then().log().all().extract().jsonPath().getString("id"));

                 System.out.println(" record created id is " + emp + "    ");




  }

@Test(priority = 2 , dependsOnMethods = "testingtestng")
    public void geyuserdetails () {

        System.out.println(" from here second method get user details ");

      given().baseUri("https://reqres.in/api/users/"+emp1)
              .when().get()
              .then().log().all();

      System.out.println("Second method completed");

  }

}
