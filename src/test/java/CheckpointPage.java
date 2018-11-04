import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckpointPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"resend-url\"]")
    private WebElement buttonSend;

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
}
