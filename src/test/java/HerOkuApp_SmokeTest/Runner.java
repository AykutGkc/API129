package HerOkuApp_SmokeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                C01_PostRequest.class,
                C02_GetRequest.class,
                C03_PutRequest.class




        }


)
//Olusturulan claslarin calisma sirasini belirtiyoruz.
public class Runner {




}
