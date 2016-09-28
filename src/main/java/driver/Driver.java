package driver;

import org.openqa.selenium.remote.RemoteWebDriver;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by taras on 9/18/16.
 */
public class Driver implements BaseDriver {

    RemoteWebDriver remoteWebDriver;

    public RemoteWebDriver getDriver() {
        return remoteWebDriver;
    }

    public void navigateToURL(String url) {
        remoteWebDriver.get(url);
    }

    public Class navigateToPage(Class page) {
        return null;
    }

    public Driver(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
    }

    public void clearCookies() {
        remoteWebDriver.manage().deleteAllCookies();
    }

    public void close() {
        remoteWebDriver.close();
    }

    public void quit() {
        remoteWebDriver.quit();
    }

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Devices.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Devices devices = (Devices) unmarshaller.unmarshal(new File("src/main/resources/devices.xml"));
            System.out.println(devices.getDevice().get(0).toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
