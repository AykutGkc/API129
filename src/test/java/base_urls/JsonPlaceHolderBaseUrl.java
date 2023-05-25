package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification spec;

    //setUp methodu ile tekrarli yapilacak islemleri topluyoru. Ve test öncesi calisacak sekilde @Before anatosyonu ekliyoruz.

    @Before //her test methodu öncesi calisir
    public void setUp() throws Exception {
        spec=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/").build();

    }
}
