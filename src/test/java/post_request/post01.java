package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class post01 extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test //String ile
    public void post01() {
        //Set the Url
        spec.pathParam("first","todos");

        //Set the expected data  //Json datayi java objesi olarak kullanmaliyiz.
        String payLoad= "{\n" +//String objesi kullanmak kolay yöntemdir ama assertion için tavsiye edilmez.
                "\"userId\": 55,\n" +
                "\"title\": \"Tidy your room\",\n" +
                "\"completed\": false\n" +
                "}";

        //send the request and get the response
        Response responce=given(spec).body(payLoad).post("{first}");
        responce.prettyPrint();

        //Do assertion
        assertEquals(201,responce.statusCode());
        JsonPath jsonPath=responce.jsonPath();
        assertEquals(55,jsonPath.getInt("userId"));
        assertEquals("Tidy your room",jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));



    }

    @Test //String ile
    public void post01Map() {
        //Set the Url
        spec.pathParam("first","todos");

        //Set the expected data  //Json datayi java objesi olarak kullanmaliyiz.

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);
        System.out.println(expectedData.get("title"));

        //send the request and get the response
        Response responce=given(spec).body(expectedData).post("{first}"); //Serialization yapildi. -->Gson kullanilarak Java objesi Json dataya cevirdik.
        responce.prettyPrint();

        //Do assertion
        Map<String,Object> actualData=responce.as(HashMap.class);//De-Serialization --> Gson kullanarak Json datayı Map Java objesine çevirdik.
        System.out.println("actualData = " + actualData);

        assertEquals(201,responce.statusCode());

        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));



    }
}
