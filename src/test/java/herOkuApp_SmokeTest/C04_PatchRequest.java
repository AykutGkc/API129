package herOkuApp_SmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static herOkuApp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C04_PatchRequest extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
         "additionalneeds": "Lunch"

        }
    When
        Send  patch request
    Then
        Status code is 200
    And
       Body:
        {
        "firstname" : "Ali",
        "lastname" : "Can",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
     */

    @Test
    public void patch01() {
        //Set the url
        spec.pathParams("first","booking","second",bookingId);

        //Set the expected data

        Map<String, Object> expectedData= new HerOkuAppTestData()
                .expectedDataMapMethod(null,null,null,null,null,"Lunch");
        System.out.println("expectedData = " + expectedData);


        //Send the request and get the response
       Response response=given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();


        //Do assertion
        Map<String,Object> actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }
}
