package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Driver {



    public static ThreadLocal<AppiumDriver>DRIVERS=new ThreadLocal<>();
    public static ThreadLocal<Device>DEVICE=new ThreadLocal<>();
    public static ThreadLocal<App>APP=new ThreadLocal<>();


    /**
     *
     * @param device
     * @param app
     */
    public static void setDriver(Device device, App app){
        AppiumDriver<MobileElement>driver;

        AppiumManager service = new AppiumManager();
        service.start();
        driver=new AndroidDriver<MobileElement>(service.getURL(),setCaps(device,app));
        DRIVERS.set(driver);
        DEVICE.set(device);
        APP.set(app);
    }

    /**
     *
     * @param device
     * @param app
     * @return
     */
    private static DesiredCapabilities setCaps(Device device, App app){
        String apk = "src/main/resources/" + app.appZipFile;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:udid", device.udid);
        capabilities.setCapability("appium:version", device.version);
        capabilities.setCapability("appium:deviceName", device.deviceName);
        capabilities.setCapability("platformName", device.platformName);
        capabilities.setCapability("appium:app", apk);

        capabilities.setCapability("appium:appPackage", app.appPackage);
        capabilities.setCapability("appium:appActivity", app.appActivitiy);

        return capabilities;
    }

    /**
     *
     */
    public static void quitDriver(){
        DRIVERS.get().quit();
        DRIVERS.set(null);
    }
}
