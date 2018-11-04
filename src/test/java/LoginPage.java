import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@class='link-forgot-password']")
    private WebElement linkForgotPassword;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this); // или вместо this - LoginPage.class

    }

    public boolean isSignInButtonDisplay(){
        return signInButton.isDisplayed();
    }


    public <T> T login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if (webDriver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(webDriver);
        }
        if (webDriver.getCurrentUrl().contains("/uas/login-submit")) {
            return (T) new LoginSubmitPage(webDriver);
        } else {
            return (T) new LoginPage(webDriver);
        }

    }

       public boolean isPageLoaded(){
           return webDriver.getCurrentUrl().contains("www.linkedin.com")
                   && webDriver.getTitle().contains("Войти")
                   && isSignInButtonDisplay();
       }

    public <C> C changePassword () {
        linkForgotPassword.click();
        try {
            sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if (webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/request-password-reset")) {
            return (C) new ChangePasswordPage(webDriver);
        }
        if (webDriver.getCurrentUrl().contains("/uas/login-submit")) {
            return (C) new LoginSubmitPage(webDriver);
        }
        else {
            return (C) new LoginPage(webDriver);
        }

    }

}
