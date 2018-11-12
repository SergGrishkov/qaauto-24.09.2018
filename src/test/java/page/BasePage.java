package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
     WebDriver webDriver;


    /**
     * Method, which wait Element Clickable
     * @param webElement
     */
     public void waitUntilElementIsClickable(WebElement webElement){
         WebDriverWait wait = new WebDriverWait(webDriver, 20);
         wait.until(ExpectedConditions.elementToBeClickable(webElement));
     }

    /**
     * Method, which wait Element Selected
     * @param webElement
     */
    public void waitUntilElementIsSelected(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeSelected(webElement));
    }

    public abstract boolean isPageLoaded ();
}
