import driver.Driver;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pool.DriverPool;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Taras_Krysiuk on 9/28/2016.
 */
public class Main {

    private static AppiumDriver dr;

    public static void main(String[] args) {
        DriverPool pool = DriverPool.getInstance();
//        Driver a = pool.getDriver();
//        Driver b = pool.getDriver();

        System.out.println("");
        try {
            dr = new DriverFactory().getAppiumDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
