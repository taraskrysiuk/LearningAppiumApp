package driver;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by taras on 9/27/16.
 */
@XmlRootElement(name = "device")
public class Device {

    String id;
    String deviceName;
    String browserName;
    String version;
    String platform;
    String location;

    //special for android
    String appPackage;
    String appActivity;
    //ios
    String app;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    @XmlElement
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getBrowserName() {
        return browserName;
    }

    @XmlElement
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getVersion() {
        return version;
    }

    @XmlElement
    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    @XmlElement
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAppPackage() {
        return appPackage;
    }

    @XmlElement
    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    @XmlElement
    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }

    public String getApp() {
        return app;
    }

    @XmlElement
    public void setApp(String app) {
        this.app = app;
    }

    public String getLocation() {
        return location;
    }

    @XmlElement
    public void setLocation(String location) {
        this.location = location;
    }
}
