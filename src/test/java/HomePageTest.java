import launcher.AbstractTestClassBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Created by taras on 9/30/16.
 */
public class HomePageTest extends AbstractTestClassBase {

    @Test
    public void searchProductIpod(){
        HomePage homePage = new HomePage(getDriver()).open();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage = new HomePage(getDriver());
        homePage.header.searchField.writeText("ipod");
        homePage.header.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(true);
    }

    @Test
    public void searchProductKeyboard(){
        HomePage homePage = new HomePage(getDriver()).open();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage = new HomePage(getDriver());
        homePage.header.searchField.writeText("keyboard");
        homePage.header.searchButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
