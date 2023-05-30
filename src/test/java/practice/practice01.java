package practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class practice01 extends RegresBaseUrl{
    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01() {
        //Set the url
        String url="https://reqres.in/api/users/3";

        //2)SEt the exected data --> Bu kisim post ve put gibi body gerektiren ileriki testlerde yapilacak.

        //3)send the request and get the response

        Response response=given().get(url);
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

    }

    /*
       Given
           https://reqres.in/api/users/23
       When
           User send a GET Request to the url
       Then
           HTTP Status code should be 404
       And
           Status Line should be HTTP/1.1 404 Not Found
       And
           Server is "cloudflare"
       And
           Response body should be empty
    */
    @Test
    public void get02() {
        //Set the url
        spec.pathParams("first","users","second",23);

        //2)SEt the exected data --> Bu kisim post ve put gibi body gerektiren ileriki testlerde yapilacak.

        //3)send the request and get the response
        Response response=given().spec(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertTrue(response.as(HashMap.class).isEmpty());//Gelen body'yi map'e çevirip boş olduğunu doğruluyoruz.
    }
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get03() {
        //set the url
        spec.pathParams("first","users","second",2);

        //Set The Expected Data

        //Send The Request and Get The Response
        Response response=given().spec(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email",equalTo("janet.weaver@reqres.in")
                ,"data.first_name",equalTo("Janet")
                ,"data.last_name",equalTo("Weaver")
                ,"support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}
