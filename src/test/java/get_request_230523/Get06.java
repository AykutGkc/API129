package get_request_230523;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {
     /*
       Given
           https://restful-booker.herokuapp.com/booking/23
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
                {
                   "firstname": "Josh",
                   "lastname": "Smith",
                   "totalprice": 111,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2018-01-01",
                       "checkout": "2019-01-01"
                   },
                   "additionalneeds": "Breakfast"
                }
     */
    @Test
    public void get06() {
        //Set the Url
        spec.pathParams("first","booking","second",480);

        //Set the expected data

        //send the request and get the responce

        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        //1.yol
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("John"),
                        "lastname",equalTo("Smith"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Breakfast"));

        //2.yol: Json path
        JsonPath jsonPath=response.jsonPath(); //jsonPath() methodu ile responce'i JsonPath objesine cevirdik

       assertEquals("John", jsonPath.getString("firstname"));
       assertEquals("Smith", jsonPath.getString("lastname"));
       assertEquals(111, jsonPath.getInt("totalprice"));
       assertTrue(jsonPath.getBoolean("depositpaid"));
       assertEquals("2018-01-01", jsonPath.getString("bookingdates.checkin"));
       assertEquals("2019-01-01", jsonPath.getString("bookingdates.checkout"));
       assertEquals("Breakfast", jsonPath.getString("additionalneeds"));

        //3.Yol: TestNG soft Assertion

        //Soft Assertion adimlari
        //1)Soft assert objesi olustur.
        SoftAssert softAssert=new SoftAssert();

        //2)Assert Yap
        softAssert.assertEquals(jsonPath.getString("firstname"),"John","firstname uyusmadi");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Smith","lastname uyusmadi");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111,"Totalprice uyusmadi");
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"),"depositpaid uyusmadi");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01","checkin uyusmadi");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01","checkout uyusmadi");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"Breakfast");

        //3)assertAll() methodunu kullan
        softAssert.assertAll();
    }
}
