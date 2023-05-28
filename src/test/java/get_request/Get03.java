package get_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
     */

    @Test
    public void Get03() {

        //1)Set the url
        String url="https://jsonplaceholder.typicode.com/todos/23";

        //2)set the expected data --> Bu kisim post ve put gibi body gerektiren ileriki testlerde yapilacak.

        //3)Send the request and get the response
        Response response=given().get(url);
        response.prettyPrint();

        //4)Do assertion
        //1.Yol:
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("userId",equalTo(2)) //Hard assertion
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false));

        //2.Yol:
        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("userId",equalTo(21),
                        "title",equalTo("et itaque necessitatibus maxime molestiae qui quas velitx"),
                        "completed",equalTo(true));

        //Tek body() methodu icinde coklu assertion yaparak "soft assertion" yapabiliriz.Tüm dail durumlari hakkinda bilgi alabiliriz.
        // Çoklu body() methodları içinde  assertion yaparak "hard assertion" yaparız. İlk durumunda çalışma durur ve sonraki assetionlar hakkında bilgi alamayız.

    }
}
