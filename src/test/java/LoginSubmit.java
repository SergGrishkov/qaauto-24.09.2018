import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSubmit {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"session_key-login\"]")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"session_password-login\"]")
    private WebElement userPasswordField;

    @FindBy (xpath = "//*[@id=\"error-for-password\"]")
    private  WebElement userErrorMessage;

    @FindBy(xpath = "//html/body/div[1]/div[1]/div/form/button")
    private WebElement signInButton;


    public LoginSubmit (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

//    public boolean isSignInButtonGuestHomeDisplay(){
//        return signInButton.isDisplayed();
//    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("uas/login-submit")
                && webDriver.getTitle().contains("Войти в LinkedIn")
                && signInButton.isDisplayed();
    }

    public <S> S login (String userEmail, String userPassword, String emailValidationMessage, String passwordValidationMessage) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        userErrorMessage.getText().contains(emailValidationMessage);
        Assert.assertEquals(passwordValidationMessage,);


    }

}
