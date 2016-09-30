package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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

    public Driver getDriverForDevice(Device device) {
        switch (device.getPlatform()){
            case "Android":
                return new Driver(getAndroidDriver(device), device);
            case "Mac":
                return new Driver(getIOSDriver(device), device);
            default:
                return null;
        }
    }

    public AndroidDriver getAndroidDriver(Device device) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", device.getDeviceName());
        capabilities.setCapability(CapabilityType.BROWSER_NAME, device.getBrowserName());
        capabilities.setCapability(CapabilityType.VERSION, device.getVersion());
        capabilities.setCapability(CapabilityType.PLATFORM, device.getPlatform());
        capabilities.setCapability("appPackage", device.getAppPackage());
        capabilities.setCapability("appActivity", device.getAppActivity());
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL("http://" + device.getLocation()  + "/wd/hub"), capabilities);
            Thread.sleep(10000);
        } catch (MalformedURLException e) {} catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public IOSDriver getIOSDriver(Device device) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.getPlatform());
        capabilities.setCapability("platformVersion", device.getVersion());
        capabilities.setCapability("browserName", device.getBrowserName());
        IOSDriver driver = null;
        try {
            driver = new IOSDriver(new URL("http://" + device.getLocation()  + "/wd/hub"), capabilities);
        } catch (MalformedURLException e) {}
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    //testing method
    public RemoteWebDriver dr() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.browser");
        capabilities.setCapability("appActivity", "com.android.browser.BrowserActivity");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:8899/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return (RemoteWebDriver) driver;
    }
}
