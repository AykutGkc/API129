package post_request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05_Object_Mapper_Map extends JsonPlaceHolderBaseUrl {
    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }


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

    @Test
    public void post05() throws JsonProcessingException {

        //Set the url
        spec.pathParam("first","todos");

        //Set the expected data
        Map<String,Object> expectedData=new JsonPlaceHolderTestData().expectedDataMapMethod(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        //ObjectMapper kullanarak response'i Java objesine ceviriyoruz. readVAlue() methodu birinci parametresinde okunacak datayi string olark alir. Ikinci parametreye cevrilecek data tipi belirtilir.
        //import com.fasterxml.jackson.databind.ObjectMapper; --> new ObjectMapper()
        Map<String,Object> actualData=new ObjectMapper().readValue(response.asString(),HashMap.class); //De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));



    }
}
