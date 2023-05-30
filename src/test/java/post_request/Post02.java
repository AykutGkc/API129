package post_request;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.Map;

public class Post02 extends HerOkuAppBaseUrl {
      /*
    Given
        1) https://restful-booker.herokuapp.com/booking
        2) {
             "firstname": "John",
             "lastname": "Doe",
             "totalprice": 11111,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2021-09-09",
                 "checkout": "2021-09-21"
              }

           }
    When
        I send POST Request to the Url
    Then
        Status code is 200
        And response body should be like {
                                            "bookingid": 5315,
                                            "booking": {
                                                "firstname": "John",
                                                "lastname": "Doe",
                                                "totalprice": 11111,
                                                "depositpaid": true,
                                                "bookingdates": {
                                                    "checkin": "2021-09-09",
                                                    "checkout": "2021-09-21"
                                                }
                                            }
                                         }
 */

    @Test
    public void post02() {
        //Set the Url
        spec.pathParam("first","booking");

        //Set the expected data
        HerOkuAppTestData obj=new HerOkuAppTestData();
        Map<String,String> bookingDatasMap=obj.bookingDatesMapMethod("2021-09-09","2021-09-21");
        Map<String,Object> expectedData=obj.expectedDataMapMethod("John","Doe",11111,true,bookingDatasMap,"");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get response
    }
}
