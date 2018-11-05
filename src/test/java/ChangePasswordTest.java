import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

/*
1. Зайти на страницу и кликнуть Сменить пароль
2. Перейти на страницу смены пароля пройти верификацию
3. Ввести почту
4. Получить ссылку и вставить в окно
5. Перейти на страницу с вводом и подветждением пароль, верифицироваться
6. Ввести пароль и подтвердить пароль, отправить


 */
public class ChangePasswordTest {
    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(webDriver);

    }

//    @AfterMethod
//    public void afterMethod () {
//        webDriver.quit();
//    }

    @Test
    public void changePassword (){

        ChangePasswordPage changePasswordPage = loginPage.changePassword();
        Assert.assertTrue(changePasswordPage.isPageLoaded(),"ChangePasswordPage page is not loaded.");

        CheckpointPage checkpointPage = changePasswordPage.checkpoint("serggrishkovedu@gmail.com");
        Assert.assertTrue(checkpointPage.isPageLoaded(),"CheckpointPage page is not loaded.");

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changePasswordPage.inputLinkFromEmail("https://www.linkedin.com/e/v2?e=bf32e8-jo4jpy91-tz&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3BsJsPrsM%2BQpqhGAB4Nk8ALw%3D%3D&a=checkpoint-password-reset&midToken=AQFbl_rMtF1W0Q&tracking=eml-jav-saved-job&ek=security_password_reset_checkpoint&encryptedEmail=AgEhR79qDkFwpQAAAWbkzDyZM_j13tgFe6FxDwSpNV3n43DY52h7HLwGyzvoYhbqYb23gBvlWUGj&requestSubmissionId=AgHTQwAyPgNlCgAAAWbkzDyeqrQG9mQ7BeAapsG0RR_KIOuv99-7t_pCbsuzJFpe4vWy2Czlmy4btsgJ6sgfGNXNvWfMFglTtOk5Oz2wAQc&oneTimeToken=-5593953045695911003&_sig=1IcWCBQlbS0ow1");

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"PageChangePasswordLoaded is not loaded");

        //CheckpointPage checkpointPage = new CheckpointPage(webDriver);
        String newPassword = "!QAz@wsx";
        checkpointPage.inputNewPassword(newPassword);

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"Page for change password is not loaded");

        ConfirmPasswordPage confirmPasswordPage = new ConfirmPasswordPage(webDriver);
        confirmPasswordPage.clickTransferToHeadPage();

        loginPage.login("SergAutoTest@bigmir.net",newPassword);

        Assert.assertTrue(loginPage.isPageLoaded());

    }

}
