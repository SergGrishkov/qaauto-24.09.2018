import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LoginTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod () {
        webDriver.quit();
    }

    @DataProvider
    public Object [][] validDataProvider() {
        return new Object[][] {
                {"SergAutoTest@bigmir.net","!qaz@wsx"}
        };
    }

    @DataProvider
    public Object[][] negativeValidDataProvider(){
        return  new Object[][]{
                {"a@b.c",""},
                {"",""},
                {"","asadsa"},

        };
    }

    @DataProvider
    public Object[][] loginSubmitDataProvider(){
        return new Object[][] {
                {"asada","fxfgdgd31","sdfs",""},
                {"SergAutoTest@bigmir.net","112233q","",""}
        };
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest (String userEmail, String userPassword)  {
        webDriver.get("https://www.linkedin.com/");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(),"HomePage is not displayed on Login Page!");

    }


       @Test (dataProvider = "negativeValidDataProvider")
       public void negativeLoginTestWithoutPassword (String userEmail, String userPassword)  {

           webDriver.get("https://www.linkedin.com/");
           LoginPage loginPage = new LoginPage(webDriver);
           Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

           loginPage.login(userEmail, userPassword);
           Assert.assertTrue(loginPage.isPageLoaded(),"Your password is not empty or incorrect!");


       }
        @Test
        public void negativeLoginTestLoginPasswordRandomChar () throws InterruptedException {

            webDriver.get("https://www.linkedin.com");
            String login = "asada";
            String password = "fxfgdgd31";

            LoginPage loginPage = new LoginPage(webDriver);
            Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

            //LoginSubmit loginSubmit = loginPage.loginSubmitPage(login,password);
            sleep(3000);
            //Assert.assertTrue(loginSubmit.isPageLoaded(),"Your password is not empty or incorrect!");
            //not working.

        }

}
