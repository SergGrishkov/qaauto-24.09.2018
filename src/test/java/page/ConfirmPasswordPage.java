package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPasswordPage extends BasePage{


    @FindBy(xpath = "//*[@id=\"reset-password-submit-button\"]")
    private WebElement buttonSubmit;


    public ConfirmPasswordPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);

    }

    public boolean isPageLoaded(){
        return buttonSubmit.isDisplayed()
                && webDriver.getTitle().contains("Вы изменили свой пароль")
                && webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/password-reset-submit");
    }


}
