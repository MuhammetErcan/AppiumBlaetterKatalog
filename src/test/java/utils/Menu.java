package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public enum Menu {

    DEFAULT(By.id("de.cominto.blaetterkatalog.example:id/action_default")),
    MYISSUES(By.id("de.cominto.blaetterkatalog.example:id/action_myissues")),
    FAVORITES(By.id("de.cominto.blaetterkatalog.example:id/action_favorites"))
    ;

    private By locator;
    private WebElement element;

    Menu(By locator) {
        this.locator = locator;
        element=Driver.DRIVERS.get().findElement(locator);
    }

    public void click(){
        element.click();
    }

    public boolean isSelected(){
        return element.isSelected();
    }

    public WebElement getElement(){
        return element;
    }

}
