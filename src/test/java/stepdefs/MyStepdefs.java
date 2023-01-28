package stepdefs;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import utils.Driver;
import utils.Menu;

import java.util.List;

import static utils.Locators.lKatalogs;


public class MyStepdefs extends BaseSteps {
    @Given("user on star page")
    public void userOnStarPage() {
        gotoStartPage();
    }

    @Then("user clicks ALL PUBLİCATİON")
    public void userClicksALLPUBLİCATİON() {
        Menu.DEFAULT.click();
    }

    @And("wait for {int} seconds")
    public void waitForSeconds(int arg0) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user clicks MY PUBLİCATİON")
    public void userClicksMYPUBLİCATİON() {
        Menu.MYISSUES.click();
    }

    @Then("user clicks FAVORİTES")
    public void userClicksFAVORİTES() {
        Menu.FAVORITES.click();
    }

    @Then("user clicks katalogs")
    public void userClicksKatalogs() {
       click(xPathKatalog("Ener"));

    }


    public void clickToKatalogL(String text){



    }

    public By xPathKatalog(String text){
        return By.xpath("//android.widget.FrameLayout[@resource-id='de.cominto.blaetterkatalog.example:id/shelf_element' \n" +
                "        and \n" +
                "        .//*[@resource-id='de.cominto.blaetterkatalog.example:id/element_title' \n" +
                "            and \n" +
                "            contains(@text,'" + text + "')]");
    }


}
