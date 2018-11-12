package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.CheckpointPage;
import page.HomePage;

/**
1. Зайти на страницу и кликнуть Сменить пароль
2. Перейти на страницу смены пароля пройти верификацию
3. Ввести почту
4. Получить ссылку и вставить в окно
5. Перейти на страницу с вводом и подветждением пароль, верифицироваться
6. Ввести пароль и подтвердить пароль, отправить
*/

public class ChangePasswordTest extends BaseTest{

    //public WebDriver webDriver;

    @Test
    public void changePassword (){

        ChangePasswordPage changePasswordPage = loginPage.changePassword();
        Assert.assertTrue(changePasswordPage.isPageLoaded(),"page.ChangePasswordPage page is not loaded.");
        CheckpointPage checkpointPage = changePasswordPage.checkpoint("serggrishkovedu@gmail.com");

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"PageChangePasswordLoaded is not loaded");

        String newPassword = "!QAZ@WSX";
        checkpointPage.inputNewPassword(newPassword);

        Assert.assertTrue(checkpointPage.isPageChangePasswordLoaded(),"Page for change password is not loaded");
        changePasswordPage.clickTransferToHeadPage();
        checkpointPage.logoutPage();


        //HomePage homePage = loginPage.login("serggrishkovedu@gmail.com", newPassword);
        //Assert.assertTrue(homePage.isPageLoaded(),"page.HomePage is not displayed on Login Page!");

    }

}
