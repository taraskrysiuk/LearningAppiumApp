package launcher;

import driver.Driver;
import org.testng.annotations.Listeners;

/**
 * Created by taras on 9/29/16.
 */
@Listeners(TestsListener.class)
public class AbstractTestClassBase {

    private Driver driver;

    public Driver getDriver(){
        return driver;
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

}
