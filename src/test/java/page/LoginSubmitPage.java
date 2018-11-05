package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSubmitPage extends BasePage{


    @FindBy(xpath = "//*[@id=\"session_key-login\"]")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"session_password-login\"]")
    private WebElement userPasswordField;

    @FindBy (xpath = "//*[@id=\"session_password-login-error\"]]")
    private  WebElement passwordValidationMessage;

    @FindBy(xpath = "//*[@id=\"session_key-login\"]")
    private  WebElement emailValidationMessage;

    @FindBy (xpath = "//div[@role='alert']")
    private WebElement allertBox;

    @FindBy(xpath = "//html/body/div[1]/div[1]/div/form/button")
    private WebElement signInButton;


    public LoginSubmitPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }


    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("uas/login-submit")
                && webDriver.getTitle().contains("Войти в LinkedIn")
                && allertBox.isDisplayed();
    }


    public String getEmailValidationMessage () {
        return emailValidationMessage.getText();
    }

    public String getPasswordValidationMessage (){
        return passwordValidationMessage.getText();
    }

    public String getAlertMessageText() {
        return allertBox.getText();
    }
}
