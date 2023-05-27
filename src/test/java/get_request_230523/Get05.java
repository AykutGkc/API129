package get_request_230523;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends a GET request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
            (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
     */

    @Test
    public void get05() {
        //Set the url
        //String url="https://restful-booker.herokuapp.com/booking?firstname=Sally&lastname=Brown";

        spec.pathParam("first","booking")
                .queryParams("firstnamee","Sally","lastname","Brown");

        //set the expected data

        //Send the request and get the responce

        Response responce=given(spec).get("{first}");
        responce.prettyPrint();

        //Do assertion
        responce.then().statusCode(200).body("bookingid", hasSize(greaterThan(0)));

        //yada

        assertTrue(responce.asString().contains("bookingid"));

    }
}
