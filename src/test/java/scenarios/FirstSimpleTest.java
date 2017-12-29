package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import setup.Driver;

import java.io.IOException;


public class FirstSimpleTest extends Driver {

    FirstSimpleTest() throws IOException {
        super();
    }

    @BeforeClass(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        prepareDriver();

    }

    @Test(description = "Open website")
    public void webTest() throws InterruptedException {
        driver.get(SUT); // this always ends OK; it's a drawback.
        // Other way to check good/bad result has to be implemented.
        //Thread.sleep(5000); // This is a reason to dismissal.
        wait.
             until(
                ExpectedConditions.
                        urlToBe(SUT+"/")); // temporary solution; it would be better to use regexp
        // Title of loaded page can be verified as well.
        // The next step is to check http status code.
        // Selenium/Appium can't do it directly so use other means (RestAssure, Apache http client, etc)
        System.out.println("Site opening done");
    }

    //@Test(description = "This simple test just click on button 'Add contact'")
    public void simplestTest(){
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver.findElement(add_btn).click(); // The result of clicking doesn't checked.
        System.out.println("Simplest Appium test done");
    }


    @AfterClass(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver.quit();
    }
}