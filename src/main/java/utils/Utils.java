package utils;

import io.appium.java_client.AppiumDriver;

public class Utils {
    public static void openApp(Device device, App app){
        Driver.setDriver(device,app);
    }
}
