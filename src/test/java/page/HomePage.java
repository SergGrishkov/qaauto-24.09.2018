package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class HomePage extends BasePage{


    @FindBy(xpath = "//li[@id = 'profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(xpath = "//a[@data-control-name='nav.settings_signout']")
    private WebElement signOutButton;

    @FindBy(xpath = "//input[contains(@aria-owns, 'result')]")
    private WebElement searchField;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public SearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchPage(webDriver);
    }

    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/feed/")
                && webDriver.getTitle().contains("LinkedIn")
                && profileNavItem.isDisplayed();
    }

}
