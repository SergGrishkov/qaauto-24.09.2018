import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"resend-url\"]")
    private WebElement buttonSend;

    @FindBy(xpath = "//*[@id=\"newPassword\"]")
    private WebElement newPassword;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"reset-password-submit-button\"]")
    private WebElement sendPasswordButton;

    private boolean isSignInEmailDisplay (){
        return sendPasswordButton.isDisplayed();
    }

    public CheckpointPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    private boolean isButtonSendDisplayed (){
        return buttonSend.isDisplayed();
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("checkpoint/rp/request-password-reset-submit")
                && webDriver.getTitle().contains("Проверьте, получили ли вы")
                && isButtonSendDisplayed();
    }

    public boolean isPageChangePasswordLoaded (){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/password-reset?requestSubmissionId")
                && webDriver.getTitle().contains("Изменить пароль")
                && newPassword.isDisplayed()
                && confirmPassword.isDisplayed();
    }

    public void inputNewPassword (String inputNewPassword) {
        newPassword.sendKeys(inputNewPassword);
        confirmPassword.sendKeys(inputNewPassword);
        sendPasswordButton.click();


    }
}
