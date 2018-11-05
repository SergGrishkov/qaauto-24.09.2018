import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class ChangePasswordPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@class='link-forgot-password']")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement inputEmailForChange;



    public ChangePasswordPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);

    }

    private boolean isSignInEmailDisplay (){
        return inputEmailForChange.isDisplayed();
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/request-password-reset")
                && webDriver.getTitle().contains("Изменить пароль | LinkedIn")
                && isSignInEmailDisplay();
    }

    public CheckpointPage checkpoint (String searchTerm) {
        inputEmailForChange.sendKeys(searchTerm);
        inputEmailForChange.sendKeys(Keys.RETURN);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckpointPage(webDriver);
    }

    public void inputLinkFromEmail(String linkFromEmail) {
        webDriver.get(linkFromEmail);
    }


}
