package elements;

import org.openqa.selenium.WebElement;

/**
 * Created by taras on 9/21/16.
 */
public class CheckBox extends Element {

    public CheckBox(WebElement element) {
        super(element);
    }

    public void check(){
        element.click();
    }

}