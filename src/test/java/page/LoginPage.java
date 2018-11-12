package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage{


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
        PageFactory.initElements(webDriver,this); // или вместо this - page.LoginPage.class

    }

    /**
     * Method for identification field on display.
     * @return
     */
    public boolean isSignInButtonDisplay(){
        return signInButton.isDisplayed();
    }


    /**
     * Method, which return page at condition random userMail and userPassword.
     * @param userEmail
     * @param userPassword
     * @param <T>
     * @return
     */
    public <T> T login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        waitUntilElementIsClickable(signInButton);
        waitUntilElementIsSelected(signInButton);
        signInButton.click();


        if (webDriver.getCurrentUrl().contains("/feed")) {
            return (T) new HomePage(webDriver);
        }
        if (webDriver.getCurrentUrl().contains("/uas/login-submit")) {
            return (T) new LoginSubmitPage(webDriver);
        } else {
            return (T) new LoginPage(webDriver);
        }

    }

    /**
     * Method for validation Page loaded.
     * @return
     */
       public boolean isPageLoaded(){
           return webDriver.getCurrentUrl().contains("www.linkedin.com")
                   && webDriver.getTitle().contains("Войти")
                   && isSignInButtonDisplay();
       }

    /**
     * Method which return Page at condition random userMail and userPassword.
     * @param <C>
     * @return
     */
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
