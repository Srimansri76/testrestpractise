package tests;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class bodydatawithhasmap {

@Test
    public void bodyhashmaptest () {

        Map<String, Object> data = new HashMap<>();

        data.put("firstname" , "Sriman");

        data.put("lastname","Parimi");

        data.put("totalprice", 76);

        data.put("depositpaid",true);

      Map<String , Object > bookdata = new HashMap<>();
      bookdata.put("checkin","2018-01-01");
      bookdata.put("checkout","2019-01-01");

      data.put("bookingdates" , bookdata);
      data.put("additionalneeds","Dinner");


System.out.println(data);


    given().contentType("application/json").baseUri("https://restful-booker.herokuapp.com/booking").body(data).

            when().post()

                    .then().log().all();

    }
}
