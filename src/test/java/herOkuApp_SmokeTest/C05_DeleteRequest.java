package herOkuApp_SmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herOkuApp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C05_DeleteRequest extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
     When
        Send delete request
     Then
        status code is 201
     And
        Body should be : "Created"

     */

    @Test
    public void delete01() {
        //Set the url
        spec.pathParams("first","booking","second",bookingId);

        //Set the expectedData
        String expectedData="Created";
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=given(spec).delete("{first}/{second}");
        response.prettyPrint();


        //Do assertion
        String actualData=response.asString();
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData,actualData);




    }
}
