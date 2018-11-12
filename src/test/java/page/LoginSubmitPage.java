package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    /**
     * Method for validation Page loaded.
     * @return
     */
    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("uas/login-submit")
                && webDriver.getTitle().contains("Войти в LinkedIn")
                && allertBox.isDisplayed();
    }


    /**
     * Method, which return validation message for Email field
     * @return
     */
    public String getEmailValidationMessage () {
        return emailValidationMessage.getText();
    }

    /**
     * Method, which return validation message for Password field
     * @return
     */
    public String getPasswordValidationMessage (){
        return passwordValidationMessage.getText();
    }

    /**
     * Method, which return validation message for Alert field
     * @return
     */
    public String getAlertMessageText() {
        return allertBox.getText();
    }
}
