package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class ChangePasswordPage extends BasePage{


    @FindBy(xpath = "//*[@class='link-forgot-password']")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement inputEmailForChange;

    @FindBy(xpath = "//*[@id=\"reset-password-submit-button\"]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//*[@id=\"newPassword\"]")
    private WebElement newPassword;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    private WebElement confirmPassword;



    public ChangePasswordPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);

    }

    /**
     * Method for identification field on display.
     * @return
     */
    private boolean isSignInEmailDisplay (){
        return inputEmailForChange.isDisplayed();
    }

    /**
     * Method for validation Page loaded.
     * @return
     */
    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/uas/request-password-reset")
                && webDriver.getTitle().contains("Изменить пароль | LinkedIn")
                && isSignInEmailDisplay();
    }

    /**
     * Method which connected to Email, wait letter, parsing letter, find link for change password and
     * cross to link.
     * @param searchTerm
     * @return
     */
    public CheckpointPage checkpoint (String searchTerm) {

        GMailService gMailService = new GMailService();
        gMailService.connect();

        inputEmailForChange.sendKeys(searchTerm);
        buttonSubmit.click();

        String messageSubject = "Serg, данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "serggrishkovedu@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 90);


        Pattern p = Pattern.compile("Чтобы изменить пароль в LinkedIn, нажмите <a href=\"([[^\"].]{0,})\"",  Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
        Matcher m = p.matcher(message);
        if (m.find()) {
            String link = m.group(1);
            link = link.replaceAll("&amp;", "&");
            System.out.println(link);
            webDriver.navigate().to(link);
        }

//        try {
//            sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new CheckpointPage(webDriver);
    }

    /**
     * Method for transfer to Head Page.
     */
    public void clickTransferToHeadPage (){
        buttonSubmit.click();
    }


}
