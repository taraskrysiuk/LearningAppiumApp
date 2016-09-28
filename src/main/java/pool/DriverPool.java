package pool;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by taras on 9/21/16.
 */
public class DriverPool {

    Map<Driver, Boolean> drivers;
    public  int poolSize;
    private Lock lock;

    public DriverPool(int poolSize) {
        lock = new ReentrantLock();
        this.poolSize = poolSize;
    }


    public Driver getDriver() {
        lock.lock();
        if (drivers == null){
            drivers = new HashMap<Driver, Boolean>();
            Driver driver  =  new Driver(new FirefoxDriver());
            drivers.put(driver, true);
            lock.unlock();
            return driver;
        }
        while(true) {
            for (Map.Entry<Driver, Boolean> driver : drivers.entrySet()) {
                if (!driver.getValue()){
                    drivers.put(driver.getKey(), true);
                    lock.unlock();
                    return driver.getKey();}
            }

            if (drivers.size() < poolSize) {
                Driver driver = new Driver(new FirefoxDriver());
                drivers.put(driver, true);
                lock.unlock();
                return driver;
            }
            lock.unlock();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
        }
    }


    public void releaseDriver(Driver driver) {
        lock.lock();
        driver.clearCookies();
        drivers.put(driver, false);
        lock.unlock();
    }


    public void releaseAll() {
        for (Map.Entry<Driver, Boolean> d: drivers.entrySet()){
            d.setValue(false);
        }
    }

    public void closeAll() {
        for (Map.Entry<Driver, Boolean> d: drivers.entrySet()){
            d.getKey().close();
            d.getKey().quit();
        }
    }


}
