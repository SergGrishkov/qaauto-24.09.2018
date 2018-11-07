package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.CheckpointPage;
import page.ConfirmPasswordPage;

import static java.lang.Thread.sleep;

/*
1. Зайти на страницу и кликнуть Сменить пароль
2. Перейти на страницу смены пароля пройти верификацию
3. Ввести почту
4. Получить ссылку и вставить в окно
5. Перейти на страницу с вводом и подветждением пароль, верифицироваться
6. Ввести пароль и подтвердить пароль, отправить


 */
public class ChangePasswordTest extends BaseTest{

    public WebDriver webDriver;

    @Test
    public void changePassword (){

        ChangePasswordPage changePasswordPage = loginPage.changePassword();
        Assert.assertTrue(changePasswordPage.isPageLoaded(),"page.ChangePasswordPage page is not loaded.");

        CheckpointPage checkpointPage = changePasswordPage.checkpoint("serggrishkovedu@gmail.com");
        Assert.assertTrue(checkpointPage.isPageLoaded(),"page.CheckpointPage page is not loaded.");


        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        changePasswordPage.inputLinkFromEmail("https://www.linkedin.com/e/v2?e=bf32e8-jo4lfsk8-4r&lipi=urn%3Ali%3Apage%3Aemail_security_password_reset_checkpoint%3Be5x0mUJ9Tz2I0M7NHtdZEg%3D%3D&a=checkpoint-password-reset&midToken=AQFbl_rMtF1W0Q&tracking=eml-jav-saved-job&ek=security_password_reset_checkpoint&encryptedEmail=AgHSAwCwRecltwAAAWbk-EM_8gpteGzWs_TUDYTKxlR0ATLZoU5CTR3theIxDLVriuKfYaGlkfn9wuE&requestSubmissionId=AgEz_mPB0UImggAAAWbk-ENLrdzrd63Hq_eVvOjANaleAikhmMNoqMMZ5F4dkrXvHc_RSS9_vErK4olVn3gmNruycedYz9sdi9n5qqUTA3o&oneTimeToken=-2121975437222171256&_sig=0wjBGfmAQC0Ew1");

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"PageChangePasswordLoaded is not loaded");

        //page.CheckpointPage checkpointPage = new page.CheckpointPage(webDriver);
        String newPassword = "!QAZ@WSX";
        checkpointPage.inputNewPassword(newPassword);

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"Page for change password is not loaded");

        ConfirmPasswordPage confirmPasswordPage = new ConfirmPasswordPage(webDriver);
        confirmPasswordPage.clickTransferToHeadPage();

        checkpointPage.logoutPage();

        loginPage.login("serggrishkovedu@gmail.com",newPassword);

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded.");

    }

}
