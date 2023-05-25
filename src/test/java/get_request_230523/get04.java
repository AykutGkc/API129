package get_request_230523;

 /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos => toplam 200 todos olması gerekir
	    And
	        "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
	    And
	        2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
     */

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class get04 extends JsonPlaceHolderBaseUrl {

    @Test
    public void get04() {
        //Set the url
        //String url="https://jsonplaceholder.typicode.com/todos"; -->Tavsiye edilmez
        spec.pathParam("first","todos"); //tekrarli islemlerin konuldugu RequestSpecition objesi

        //Set the expected data

        //Send the request and get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();





    }
}
