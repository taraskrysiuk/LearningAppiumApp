import driver.Driver;
import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.annotations.Test;
import pages.HomePage;
import pool.DriverPool;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by taras on 9/1/16.
 */
public class CalcTest {





    @Test
    public void test(){
//        DriverPool pool = new DriverPool(1);
//        Driver driver = pool.getDriver();
//        driver.navigateToURL("http://www.cybermonday.com");
//        HomePage homePage = new HomePage(driver);
//        homePage.open();
//
//        WebDriver driver = null;
//        try {
//            driver = DriverFactory.getAppiumDriver();
//            driver = DriverFactory.getDriver("");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        screen(driver);
//        driver.get("http://google.com.ua");
//
//        driver.get("http://vk.com");

    }

    public void screen(WebDriver driver){
        String destDir = "screen";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        new File(destDir).mkdirs();
        try {
            FileUtils.copyFile(srcFile, new File(destDir + "/" + "1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
