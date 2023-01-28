package temp;

import org.testng.annotations.Test;
import utils.App;
import utils.AppiumManager;
import utils.Device;

import static utils.Utils.openApp;

public class Test1 {
    @Test
    public void startAppiumTest(){
        AppiumManager appiumManager = new AppiumManager();
        appiumManager.start();
        appiumManager.stop();
    }

    @Test
    public void startApp(){
        openApp(Device.Samsung, App.BLATTER);
    }
}
