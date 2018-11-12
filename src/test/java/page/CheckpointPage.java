package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPage extends BasePage{


    @FindBy(xpath = "//*[@id=\"resend-url\"]")
    private WebElement buttonSend;

    @FindBy(xpath = "//*[@id=\"newPassword\"]")
    private WebElement newPassword;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"reset-password-submit-button\"]")
    private WebElement sendPasswordButton;

    @FindBy(xpath = "//*[@id=\"nav-settings__dropdown-trigger\"]")
    private WebElement nativeContainer;

    @FindBy(xpath = "//*[@id=\"nav-settings__dropdown-options\"]/li[4]/ul")
    private WebElement logout;

    private boolean isSignInEmailDisplay (){
        return sendPasswordButton.isDisplayed();
    }

    public CheckpointPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    /**
     * Method for identification field on display.
     * @return
     */
    private boolean isButtonSendDisplayed (){
        return buttonSend.isDisplayed();
    }

    /**
     * Method for validation Page loaded.
     * @return
     */
    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("checkpoint/rp/")
                && webDriver.getTitle().contains("пароль")
                && isButtonSendDisplayed();
    }

    /**
     * Method for validation Page loaded.
     * @return
     */
    public boolean isPageChangePasswordLoaded (){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/checkpoint/rp/password-reset")
                && webDriver.getTitle().contains("пароль");
    }

    /**
     * Method which input new password for change
     * @return
     */
    public void inputNewPassword (String inputNewPassword) {
        newPassword.sendKeys(inputNewPassword);
        confirmPassword.sendKeys(inputNewPassword);
        sendPasswordButton.click();

    }

    /**
     * Method for logout from account.
     * @return
     */
    public void logoutPage() {
        nativeContainer.click();
        logout.click();

    }
}
