import launcher.AbstractTestClassBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Created by taras on 9/30/16.
 */
public class SearchResultTest extends AbstractTestClassBase {

    @Test
    public void searchProductPen(){
        new HomePage(getDriver()).open();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HomePage homePage = new HomePage(getDriver());
        homePage.header.searchField.writeText("pen");
        homePage.header.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(true);
    }

    @Test
    public void searchProductPhone(){
        new HomePage(getDriver()).open();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HomePage homePage = new HomePage(getDriver());
        homePage.header.searchField.writeText("phone");
        homePage.header.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(true);
    }
}
