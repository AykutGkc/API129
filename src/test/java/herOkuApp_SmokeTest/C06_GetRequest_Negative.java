package herOkuApp_SmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herOkuApp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C06_GetRequest_Negative extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        Set get request
    Then
        Status code is 404
    And
        Body is "Not Found"
     */
    @Test
    public void get02_negative() {
    //Set the url
        spec.pathParams("first","booking","second",bookingId);

    //Set the expected data
    String expectedData="Not Found";

    //send the request and get the response
    Response response=given(spec).get("{first}/{second}");
    response.prettyPrint();

    //Do assetion
     assertEquals(404,response.statusCode());
     assertEquals(expectedData,response.asString());



    }
}
