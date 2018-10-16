import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {

    @Test
    public void successfulLoginTest () throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://linkedin.com");

        String linkSite = webDriver.getCurrentUrl();

        String login = "SergAutoTest@bigmir.net";
        String loginXpath = "//*[@id=\"login-email\"]";
        String pwd = "!qaz@wsx";
        String pwdXpath = "//*[@id=\"login-password\"]";
        String buttonXpath = "//*[@id=\"login-submit\"]";
        String feedLink = "https://www.linkedin.com/feed/";

        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite, "HomePage URL is correct!");

        WebElement searchFieldLogin = webDriver.findElement(By.xpath(loginXpath));
        searchFieldLogin.sendKeys(login);
        WebElement searchFieldPwd = webDriver.findElement(By.xpath(pwdXpath));
        searchFieldPwd.sendKeys(pwd);
        WebElement searchFieldButton = webDriver.findElement(By.xpath(buttonXpath));
        searchFieldButton.click();


        Assert.assertEquals(webDriver.getCurrentUrl(),feedLink, "AccountPage URL is not correct!");

        webDriver.quit();

    }

}
