package elements;

import org.openqa.selenium.WebElement;

/**
 * Created by taras on 9/21/16.
 */
public class Element implements BaseElement{

    public WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    public boolean isDisplayed(){
        return element.isDisplayed();
    }

    public boolean isEnabled(){
        return element.isEnabled();
    }

}
