package practice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class RegresBaseUrl {
    protected RequestSpecification spec;

    //setUp methodu ile tekrarli yapilacak islemleri topluyoru. Ve test öncesi calisacak sekilde @Before anatosyonu ekliyoruz.

    @Before //her test methodu öncesi calisir
    public void setUp() throws Exception {
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).setBaseUri("https://reqres.in/api").build();

    }
}
