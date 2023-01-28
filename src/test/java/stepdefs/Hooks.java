package stepdefs;

import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.App;
import utils.Device;
import utils.Driver;

import static utils.Locators.lSkipButton;
import static utils.Menu.DEFAULT;
import static utils.Utils.openApp;

public class Hooks {
    @BeforeAll
    public static void beforeAll(){
        openApp(Device.Samsung, App.BLATTER);
        new WebDriverWait(Driver.DRIVERS.get(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(lSkipButton)).click();
    }

    @AfterAll
    public static void afterAll(){
       // Driver.quitDriver();
    }

    @After
    public void afterScenario(){

        while (true){
            ApplicationState applicationState = Driver.DRIVERS.get().queryAppState(Driver.APP.get().appPackage);
            if (applicationState.equals(ApplicationState.RUNNING_IN_BACKGROUND))
                Driver.DRIVERS.get().activateApp(Driver.APP.get().appPackage);

            if (!DEFAULT.getElement().isDisplayed())
                Driver.DRIVERS.get().navigate().back();
            else if (DEFAULT.getElement().isDisplayed() && !DEFAULT.isSelected())
                DEFAULT.click();
            else
                break;
        }
    }

}
