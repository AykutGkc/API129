package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {
    public Map<String, String> bookingDatesMapMethod (String checkin, String checkout){
        Map<String, String> bookingsDatesMap = new HashMap<>();
        bookingsDatesMap.put("checkin", checkin);
        bookingsDatesMap.put("checkout", checkout);

        return bookingsDatesMap;
    }

    public Map<String, Object> expectedDataMapMethod (String firstname, String lastname, int totalprice, boolean depositpaid,Map<String, String> bookingsDatesMap, String additionalneeds){

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname",firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice",totalprice );
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingsDatesMap);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;

    }

}

