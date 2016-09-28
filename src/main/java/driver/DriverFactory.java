package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/**
 * Created by taras on 8/31/16.
 */
public class DriverFactory {


    //get driver fos os(android, ios)
    public static WebDriver getDriver(String os) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "WEXLER TAB7B_3G");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "5.1.0");
        capabilities.setCapability(CapabilityType.PLATFORM, "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:8888/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

//    public static WebDriver getDriver(String os) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "emulator-5556");
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
//        capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
//        capabilities.setCapability("platformName", "Android");
//        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return driver;
//    }
//
    public static AppiumDriver getAppiumDriver() throws MalformedURLException {
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5556");
        capabilities.setCapability(CapabilityType.VERSION, "5.1.1");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability("platformName", "Android");
            AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }
}
