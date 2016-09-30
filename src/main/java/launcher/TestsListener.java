package launcher;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import pool.DriverPool;

import java.io.File;
import java.io.IOException;

/**
 * Created by taras on 9/30/16.
 */
public class TestsListener extends TestListenerAdapter implements ITestListener{

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        Object currentClass = tr.getInstance();
        Driver driver = ((AbstractTestClassBase) currentClass).getDriver();
        makeScreenshot(driver,tr);
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        ((AbstractTestClassBase)testContext.getAllTestMethods()[0].getInstance()).setDriver(DriverPool.getInstance().getDriver());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        DriverPool.getInstance().releaseDriver(((AbstractTestClassBase)testContext.getAllTestMethods()[0].getInstance()).getDriver());
    }

    private void makeScreenshot(Driver driver, ITestResult testResult) {
        String destDir = "screen/" + testResult.getTestClass().getName() + "/" + testResult.getMethod().getMethodName() + "/";
        String old = ((AppiumDriver) driver.getDriver()).getContext();
        ((AppiumDriver) driver.getDriver()).context("NATIVE_APP");
        File srcFile = driver.getDriver().getScreenshotAs(OutputType.FILE);
        new File(destDir).mkdirs();
        try {
            FileUtils.copyFile(srcFile, new File(destDir + "/" + "1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((AppiumDriver) driver.getDriver()).context(old);
    }

}
