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


        webDriver.get("https://linkedin.com");

        String linkSite = webDriver.getCurrentUrl();
        String login = "SergAutoTest@bigmir.net";
        String pwd = "!qaz@wsx";
        String homeLink = "https://www.linkedin.com/feed/";

        LoginPage loginPage = new LoginPage(webDriver);

        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite, "HomePage URL is correct!");

        loginPage.login(login, pwd);

        Assert.assertEquals(webDriver.getCurrentUrl(),homeLink, "AccountPage URL is correct!");


    }


    @Test
    public void negativeLoginTest () {

        webDriver.get("https://linkedin.com");

        String linkSite = webDriver.getCurrentUrl();

        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite, "HomePage URL is correct!");

        String login = "a@b.c";
        String pwd = "";
//        String homeLink = "https://www.linkedin.com/feed/";

        WebElement userEmailField = webDriver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        WebElement userPasswordField = webDriver.findElement(By.xpath("//*[@id=\"login-password\"]"));
        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"login-submit\"]"));

        userEmailField.sendKeys(login);
        userPasswordField.sendKeys(pwd);
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite, "HomePage URL is correct!");


    }

}
