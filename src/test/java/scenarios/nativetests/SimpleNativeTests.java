package scenarios.nativetests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "native")
public class SimpleNativeTests extends Driver {

    protected SimpleNativeTests() throws IOException {
        super();
    }

    @Test(description = "Click on the button 'Add contact' and make sure all contact fields appear")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        // Check Target Account, Contact Name, Contact phone appears
        assert driver().findElement(By.id(app_package_name + "accountSpinner")).isDisplayed() : "Target Account selection is not displayed";
        assert driver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Target Account\"]")).getAttribute("text").contains("Target Account") : "Improper title of Target Account";

        // TODO: Check virtual keyboard appears

        // TODO: heck pop-up "Tap to Google Search and more" appears: ??????????

        System.out.println("Simplest Appium test done");
    }
}
