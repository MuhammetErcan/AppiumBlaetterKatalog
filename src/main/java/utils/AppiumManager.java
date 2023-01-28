package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.URL;

public class AppiumManager {
    private AppiumDriverLocalService service;


    public void start(){
        service=new AppiumServiceBuilder()
               // .withLogFile(new File("target/appium.log"))
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();

        service.start();
    }

    public void stop(){
        service.stop();
    }

    public AppiumDriverLocalService getService(){
        return service;
    }

    public URL getURL(){
        return service.getUrl();
    }

}
