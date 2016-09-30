package driver;

import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by taras on 9/18/16.
 */
public interface BaseDriver {

    RemoteWebDriver getDriver();
    Device getDeviceInfo();
    void navigateToURL(String ur);
    Class navigateToPage(Class page);
    void clearCookies();
    void close();
    void quit();


}
