import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmit {
    private WebDriver webDriver;

    private WebElement userEmailField;
    private WebElement userPasswordField;
    private WebElement signInButton;

    public LoginSubmit (WebDriver webDriver){
        this.webDriver = webDriver;
        initElements();
    }

    public boolean isSignInButtonGuestHomeDisplay(){
          return signInButton.isDisplayed();
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && webDriver.getTitle().equals("Войти в LinkedIn")
                && isSignInButtonGuestHomeDisplay();
    }

    private void initElements () {
        userEmailField = webDriver.findElement(By.xpath("//*[@id=\"session_key-login\"]"));
        userPasswordField = webDriver.findElement(By.xpath("//*[@id=\"session_password-login\"]"));
        signInButton = webDriver.findElement(By.xpath("//*[@id=\"btn-primary\"]"));

    }
}
