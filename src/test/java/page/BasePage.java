package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
     WebDriver webDriver;

     public void waitUntilElementIsClicable(WebElement webElement){
         WebDriverWait wait = new WebDriverWait(webDriver, 5);
         wait.until(ExpectedConditions.elementToBeClickable(webElement));
     }

    public abstract boolean isPageLoaded ();
}
