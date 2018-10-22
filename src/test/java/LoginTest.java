import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void successfulLoginTest () throws InterruptedException {


        webDriver.get("https://www.linkedin.com/");

        String login = "SergAutoTest@bigmir.net";
        String password = "!qaz@wsx";

        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

        HomePage homePage = loginPage.login(login, password);

        Assert.assertTrue(homePage.isPageLoaded(),"HomePage is not displayed on Login Page!");

    }


    @Test
    public void negativeLoginTestWithoutPassword () throws InterruptedException {

        webDriver.get("https://www.linkedin.com/");
        String login = "a@b.c";
        String password = "";

        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

        loginPage.login(login,password);

        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(),"Your password is not empty or incorrect!");


    }


    @Test
    public void negativeLoginTestLoginPasswordEmpty () throws InterruptedException {

        webDriver.get("https://www.linkedin.com/");
        String login = "";
        String password = "";

        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        loginPage.login(login,password);
        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(),"Your password is not empty or incorrect!");


    }

    @Test
    public void negativeLoginTestLoginPasswordRandomChar () throws InterruptedException {

        webDriver.get("https://www.linkedin.com");
        String login = "asada";
        String password = "fxfgdgd31";

        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        loginPage.login(login,password);

        LoginSubmit loginSubmit = new LoginSubmit(webDriver);
        sleep(3000);
        Assert.assertTrue(loginSubmit.isPageLoaded(),"Your password is not empty or incorrect!");
        //not working.

    }

    @Test
    public void negativeLoginTestLoginEmptyPasswordRandom () throws InterruptedException {

        webDriver.get("https://www.linkedin.com/");
        String login = "";
        String password = "asadsa";

        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        loginPage.login(login,password);
        sleep(3000);
        Assert.assertTrue(loginPage.isPageLoaded(),"Your password is not empty or incorrect!");


    }

    @Test
    public void negativeLoginTestWithIncorrectPassword() throws InterruptedException {
        webDriver.get("https://www.linkedin.com");
        String login = "SergAutoTest@bigmir.net";
        String password = "112233q";

        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        loginPage.login(login,password);

        LoginSubmit loginSubmit = new LoginSubmit(webDriver);
        sleep(3000);
        Assert.assertTrue(loginSubmit.isPageLoaded(),"Your password is not empty or incorrect!");

    }

}
