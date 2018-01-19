package scenarios.webtests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import setup.Driver;


@Test(groups = "web")
public class SimpleWebTests extends Driver {

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT); // this always ends OK; it's a drawback.
        // Other way to check good/bad result has to be implemented.
        //Thread.sleep(5000); // This is a reason to dismissal.
        driverWait().
                until(
                        ExpectedConditions.
                                urlToBe(SUT+"/")); // temporary solution; it would be better to use regexp
        // Title of loaded page can be verified as well.
        // The next step is to check http status code.
        // Selenium/Appium can't do it directly so use other means (RestAssure, Apache http client, etc)
        System.out.println("Site opening done");
    }

}
