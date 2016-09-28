package elements;

import org.openqa.selenium.WebElement;

/**
 * Created by taras on 9/21/16.
 */
public class InputField extends Element {

    public InputField(WebElement element) {
        super(element);
    }

    public void writeText(String text){
        element.sendKeys(text);
    }
}
