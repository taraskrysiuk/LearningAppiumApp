package pages;

import decorator.Decorator;
import driver.Driver;
import elements.Button;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sections.HeaderSection;

/**
 * Created by taras on 9/21/16.
 */
public class HomePage extends BasePage {

    @FindBy(css = "div.mn_search.mn_searchHeader")
    public HeaderSection header;

    public HomePage(Driver driver) {
        super(driver);
        PageFactory.initElements(new Decorator(driver),this);
    }

    public HomePage open(){
        driver.navigateToURL("http://www.cybermonday.com");
        return new HomePage(driver);
    }
}
