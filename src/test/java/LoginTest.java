import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;


public class LoginTest {

    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(webDriver);

    }

    @AfterMethod
    public void afterMethod () {
        webDriver.quit();
    }

    @DataProvider
    public Object [][] validDataProvider() {
        return new Object[][] {
                {"serggrishkovedu@gmail.com","!QAz@wsx"}
        };
    }





    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest (String userEmail, String userPassword)  {

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(),"HomePage is not displayed on Login Page!");

    }


    @DataProvider
    public Object[][] negativeValidDataProvider(){
        return  new Object[][]{
                {"a@b.c",""},
                {"",""},
                {"","asadsa"},

        };
    }


       @Test (dataProvider = "negativeValidDataProvider")
       public void negativeLoginWithIncorrectParameters (String userEmail, String userPassword)  {

           Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

           loginPage.login(userEmail, userPassword);
           Assert.assertTrue(loginPage.isPageLoaded(),"Your password is not empty or incorrect!");


       }


    @DataProvider
    public Object[][] validationMessagesCombinations(){
        return new Object[][] {
                {"SergAutoTest@bigmir.net","fxfgdgd31","*****************************************************///**************",""}
                //{"SergAutoTest@bigmir.net","","","fdfhfghfhg"}
        };
    }

        @Test (dataProvider = "validationMessagesCombinations")
        public void validationMessageOnInvalidEmailPassword (String userEmail,
                                                             String userPassword,
                                                             String emailValidationMessage,
                                                             String passwordValidationMessage)  {

            Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

            LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);
            Assert.assertTrue(loginSubmitPage.isPageLoaded(),"LoginSubmitPage page is not loaded." );

            Assert.assertEquals(loginSubmitPage.getAlertMessageText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                    "Alert message text is wrong.");
            Assert.assertEquals(loginSubmitPage.getEmailValidationMessage(), emailValidationMessage,"Email validation is wrong!");
            Assert.assertEquals(loginSubmitPage.getPasswordValidationMessage(), passwordValidationMessage,"Password validation is wrong!");
        }


}
