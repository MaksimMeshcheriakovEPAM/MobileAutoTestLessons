package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Initialize a driver with test properties
 */
public class Driver extends TestProperties{
    protected AppiumDriver driver;
    protected DesiredCapabilities capabilities;

    // Properties to be read
    protected String AUT; // (mobile) app under testing
    protected String SUT; // site under testing
    protected String TEST_PLATFORM;
    protected String DRIVER;

    protected Driver() throws IOException {
        AUT = getProp("aut");
        SUT = "http://"+getProp("sut");
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * @throws Exception
     */
    protected void prepareDriver(/*, String absAppPath, String appName*/) throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        switch(TEST_PLATFORM){
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554"); // default Android emulator
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default: throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        if(AUT != null){
            File app = new File(AUT);

            //tell Appium where the location of the app is
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        }

        // Init driver for local Appium server with capabilities have been set
        driver = new AppiumDriver(new URL(DRIVER), capabilities);

    }

}
