package get_request_230523;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    1)Postman manuel test icin kullanilir.
    2)API otomasyonu icin Rest-Assured Library kullaniyoruz.
    3)Otomasyon kodlarinin yazimi icin su adimlarin izlenmesi gerekir.
        a)Gereksinimleri anlama.
        b)Test case'i yazma:
            -Test yazmak icin 'Gherkin Language' kullaniyoruz.
            x) Gicen : ön kosullar-->endpoint, body...
            y)When: Yapilacak islemler --> get,put,delete...
            z)Then: Dönütler --> assertion,Close...
            t)And:Artarda kullanilan ayni islemler icin and kullanilir
        c)Otomasyon kodlarini yazma
           i)set the URRL --> Endpointi kur.
           ii)Set expected data --> beklenen veriyi kur
           iii)Send the request and get  the response --> Request yolla , response al
           iv)Do assertion --> Dogrulama yap
     */
    public static void main(String[] args) {

        //Get request nasil yapilir
        String endPoint="https://petstore.swagger.io/v2/pet/1234567890";
        Response response=  given().get(endPoint); //io.restassured.RestAssured.given
        response.prettyPrint();//prettyPrint() methodu response'e yazdirir.

        //Status Code nasil yazdirir?
        System.out.println("Status Code: " +response.statusCode());

        //Content Type nasil yazdirilir:
        System.out.println("Content Type: " + response.contentType());

        //StatusLine nasil yazdirilir:
        System.out.println("StatusLine: "+response.statusLine());

        //Header nasil yazdiririlir
        System.out.println(response.header("Server"));
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Access-Control-Allow-Methods"));
        System.out.println(response.header("Date"));

        //Headers nasil yazdirilir

        System.out.println("---------------------");
        System.out.println("response.headers() = " + response.headers());

        //Time nasil yazdirilir.
        System.out.println("Time: " +response.time());

    }
}
