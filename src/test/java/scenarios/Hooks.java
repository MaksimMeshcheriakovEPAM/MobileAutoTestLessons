package scenarios;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.Driver;
import setup.PropertyFile;

/**
 * Code to be run before and after test suites.
 * Particularly to setup and teardown an Appium driver.
 */
public class Hooks extends Driver {

    // TODO: improve initialization scheme
    // TODO: improve using of settings

    @BeforeSuite(groups = {"web"})
    void setWeb() throws Exception {
        setPropertyFile(PropertyFile.WEB);
        prepareDriver();
    }

    @BeforeSuite(groups = {"native"})
    void setNative() throws Exception {
        setPropertyFile(PropertyFile.NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"hybrid"})
    void setHybrid() throws Exception {
        setPropertyFile(PropertyFile.HYBRID);
        prepareDriver();
    }

    @AfterSuite(description = "Close driver on all tests completion",
                groups = {"native","web","hybrid"}
    )
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }


}
