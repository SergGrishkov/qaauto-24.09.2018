import org.openqa.selenium.By;
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
            return (T) new LoginSubmit(webDriver);
        } else {
            return (T) new LoginPage(webDriver);
        }

    }

       public boolean isPageLoaded(){
           return webDriver.getCurrentUrl().equals("https://www.linkedin.com/")
                   && webDriver.getTitle().equals("LinkedIn: Войти или зарегистрироваться")
                   && isSignInButtonDisplay();
       }
//
//
//    public HomePage login (String userEmail, String userPassword){
//        userEmailField.sendKeys(userEmail);
//        userPasswordField.sendKeys(userPassword);
//        signInButton.click();
//        return new HomePage(webDriver);
//        //найти ответ в Гугл на реализацию метода для перебора Логина
//    }
//
//    public LoginSubmit loginSubmitPage (String userEmail, String userPassword){
//        userEmailField.sendKeys(userEmail);
//        userPasswordField.sendKeys(userPassword);
//        signInButton.click();
//        return new LoginSubmit(webDriver);
//        //найти ответ в Гугл на реализацию метода для перебора Логина
//    }

}
