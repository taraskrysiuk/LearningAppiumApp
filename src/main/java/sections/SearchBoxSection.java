package sections;

import decorator.Decorator;
import elements.Button;
import elements.InputField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by taras on 9/18/16.
 */
public class SearchBoxSection extends BaseSection{

    @FindBy(xpath = "//*[@class='mn_searchInput']")
    public InputField searchField;

    @FindBy(xpath = "//form.mn_searchForm button")
    public Button searchButton;

    public SearchBoxSection(WebElement root) {
        super(root);
        PageFactory.initElements(new Decorator(root),this);
    }

}
