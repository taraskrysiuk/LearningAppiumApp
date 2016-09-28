package elements;

/**
 * Created by taras on 9/21/16.
 */
import org.openqa.selenium.WebElement;

public class Button extends Element {

    public Button(WebElement element) {
        super(element);
    }

    public void click(){
        element.click();
    }

}
