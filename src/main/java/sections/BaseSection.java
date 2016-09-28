package sections;

import decorator.Decorator;
import driver.Driver;
import elements.BaseElement;
import elements.Element;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by taras on 9/18/16.
 */
public abstract class BaseSection extends Element implements BaseElement{

    public BaseSection(WebElement root) {
        super(root);
    }
}
