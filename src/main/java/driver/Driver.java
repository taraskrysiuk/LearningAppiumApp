package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Set;

/**
 * Created by taras on 9/18/16.
 */
public class Driver implements BaseDriver {

    RemoteWebDriver remoteWebDriver;
    Device device;
    public RemoteWebDriver getDriver() {
        return remoteWebDriver;
    }

    @Override
    public Device getDeviceInfo() {
        return device;
    }

    public void navigateToURL(String url) {
        remoteWebDriver.get(url);
    }

    public Class navigateToPage(Class page) {
        return null;
    }

    public Driver(AppiumDriver remoteWebDriver, Device device) {
        Set<String> context = remoteWebDriver.getContextHandles();
        for (String s : context){
            if(s.contains("WEBVIEW")){
                remoteWebDriver.context(s);
            }
        }
        this.remoteWebDriver = remoteWebDriver;
        this.device = device;
    }

    public void clearCookies() {
    }

    public void close() {
        remoteWebDriver.close();
    }

    public void quit() {
        remoteWebDriver.quit();
    }


}
