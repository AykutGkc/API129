package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//<T> T -->Herhangibir data tipini temsil eder.
//readValue methodu 1.parametrede aldigi String Json datayi ikinci parametrede belirtilen data tipine cevirir.
public class ObjectMapperUtils {
    public static <T> T convertJsonToJava(String json, Class<T> cls){ //Generic method
        try {
            return new ObjectMapper().readValue(json,cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
