import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



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
    public void successfulLoginTest ()  {


        webDriver.get("https://www.linkedin.com/");

        //String linkSite = webDriver.getCurrentUrl();
        String login = "SergAutoTest@bigmir.net";
        String password = "!qaz@wsx";
        String homeLinkFeed = "https://www.linkedin.com/feed/";

        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");

        loginPage.login(login, password);

        Assert.assertEquals(webDriver.getCurrentUrl(),homeLinkFeed, "AccountPage URL is correct!");
        Assert.assertEquals(webDriver.getTitle(),"LinkedIn","Home Page title is wrong!"); //s2: comment if assert will down

        HomePage homePage = new HomePage(webDriver);
        //Assert.assertTrue(homePage.profileNavItem.isDisplayed(),"signInButton is not Displayed on login page.");//s: comment if assert will down
    }


    @Test
    public void negativeLoginTestWithoutPassword () {

        webDriver.get("https://www.linkedin.com/");
        String linkSite = webDriver.getCurrentUrl();
        String login = "a@b.c";
        String password = "";
        String homeLink = "https://www.linkedin.com/";

        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite, "HomePage URL is correct!");

        loginPage.login(login,password);

        Assert.assertEquals(webDriver.getCurrentUrl(),homeLink, "You are not logged in to your account!");


    }

    @Test
    public void negativeLoginTestWithIncorrectPassword() {
        webDriver.get("https://www.linkedin.com");
        String linkSite = webDriver.getCurrentUrl();
        String login = "SergAutoTest@bigmir.net";
        String password = "112233q";
        String homeLinkGuest = "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME";

        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite, "HomePage URL is correct!");

        loginPage.login(login,password);

        Assert.assertEquals(webDriver.getCurrentUrl(),homeLinkGuest, "You are not logged in to your account!");

    }

}
