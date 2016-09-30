package pages;

import decorator.Decorator;
import driver.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sections.HeaderSection;

/**
 * Created by taras on 9/30/16.
 */
public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='mn_brandHeader']")
    public HeaderSection header;

    public SearchResultsPage(Driver driver) {
        super(driver);
        PageFactory.initElements(new Decorator(driver.getDriver()),this);
    }

}
