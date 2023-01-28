package stepdefs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

import static utils.Menu.DEFAULT;

public class BaseSteps {
    AppiumDriver<?>driver= Driver.DRIVERS.get();
    WebDriverWait wait=new WebDriverWait(driver,30);

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void gotoStartPage(){
        ApplicationState applicationState = Driver.DRIVERS.get().queryAppState(Driver.APP.get().appPackage);
        if (applicationState.equals(ApplicationState.RUNNING_IN_BACKGROUND))
            Driver.DRIVERS.get().activateApp(Driver.APP.get().appPackage);

        while (true){
            if (!DEFAULT.getElement().isDisplayed())
                driver.navigate().back();
            else if (DEFAULT.getElement().isDisplayed() && !DEFAULT.isSelected())
                DEFAULT.click();
            else
                break;
        }
    }

    public void click(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void swipeV(double startPoint, double stopPoint){
        int w = driver.manage().window().getSize().width;
        int h = driver.manage().window().getSize().height;

        new TouchAction<>(driver)
                .press(PointOption.point(w/2, (int)(h*startPoint)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(w/2, (int)(h*stopPoint)))
                .release()
                .perform();
    }

    public void swipeUntil(By locator){
        while (driver.findElements(locator).size()<=0)
            swipeV(.6, .4);
    }




}
