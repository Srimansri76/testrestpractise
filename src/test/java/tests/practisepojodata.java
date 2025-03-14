package tests;

import org.json.JSONArray;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class practisepojodata {


    @Test
    public void practisepojodata1 () {

        pojo pj =new pojo();

//        String firstname;
//        String lastname;
//        float totalprice;
//        boolean depositpaid;
//        Object[] bookingdates;
//        String additionalneeds;

        pj.setFirstname("Sriman");
        pj.setLastname("Sri");
        pj.setTotalprice(76);
        pj.setDepositpaid(true);
        pj.setBookingdates("2018-01-01", "2019-01-01");
        pj.setAdditionalneeds("Lunch");


        given().contentType("application/json").baseUri("https://restful-booker.herokuapp.com/booking").body(pj)
                .when().post()
                            .then().log().all();

        System.out.println (" With pojo succesfully created API's testing");







    }
}
