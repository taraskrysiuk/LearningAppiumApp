package pages;

import driver.Driver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by taras on 9/21/16.
 */
public abstract class BasePage {

    protected Driver driver;

    public BasePage(Driver driver) {
        this.driver = driver;
    }
}
