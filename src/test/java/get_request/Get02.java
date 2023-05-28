package get_request;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02 {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be "HTTP/1.1 404 Not Found"
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void get02() {

        //1)Set the url
        String url="https://restful-booker.herokuapp.com/booking/0";


        //2)set the expected data --> Bu kisim post ve put gibi body gerektiren ileriki testlerde yapilacak.

        //3) Send the request and get the pesponse
        Response response=given().get(url);
        response.prettyPrint();

        //Do Assertion
    response.then()
            .statusCode(404)//HTTP/1.1 404 Not Found
            .statusLine("HTTP/1.1 404 Not Found");

    //  Response body contains "Not Found"
        Assert.assertTrue(response.asString().contains("Not Found")); //toString()  kullanmayiniz

        //Response body does not contain "TechProEd"
        Assert.assertFalse(response.asString().contains("TechPro"));

        //Server is "Cowboy"

        String server=response.header("Server");
        Assert.assertEquals("Cowboy",server);



    }
}
