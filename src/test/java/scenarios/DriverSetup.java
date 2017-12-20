package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    //protected AndroidDriver driver;
    protected AppiumDriver driver;

    /**
     * Set of capabilities to test Android native app
     * @throws MalformedURLException
     */
    protected void prepareAndroidNative() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location, e.g. "resources" folder of the project
        File appDir = new File("C:\\Users\\Maksim_Meshcheriakov\\IdeaProjects\\MyFirstTrainingAppiumTest\\src\\main\\resources");
        File app = new File(appDir, "ContactManager.apk");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    /**
     * Set of capabilities to test Android web app
     * @throws MalformedURLException
     */
    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");

        // specific web capabilities
        capabilities.setCapability("browserName", "Chrome");
        //capabilities.setCapability("browserName", "Browser");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     * @param platform
     * @param absAppPath
     * @param appName
     * @throws MalformedURLException
     */
    protected void prepareDriver(String platform, String absAppPath, String appName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
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

    /**
     * Set of capabilities to test iOS web app
     * @throws MalformedURLException
     */
    protected void prepareIosdWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory iOS capabilities

        // specific web capabilities

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }
}
