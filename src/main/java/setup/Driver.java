package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    protected AppiumDriver driver;
    protected DesiredCapabilities capabilities;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * @param platform
     * @param absAppPath
     * @param appName
     * @throws MalformedURLException
     */
    protected void prepareDriver(String platform, String absAppPath, String appName) throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        switch(platform){
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554"); // default Android emulator
                browserName = "Chrome";
                break;
            case "iOS":
                browserName = "Safari";
                break;
            default: throw new Exception("Unknown mobile platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
        if(appName != null){
            File appDir = new File(absAppPath);
            File app = new File(appDir, appName);
            //tell Appium where the location of the app is
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        }

        // Init driver for local Appium server with capabilities have been set
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

}
