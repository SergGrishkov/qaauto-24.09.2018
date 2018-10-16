import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {

    @Test
    public void successfulLoginTest () throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://linkedin.com");


        String linkSite = webDriver.getCurrentUrl();
        String login = "SergAutoTest@bigmir.net";
        String loginXpath = "//*[@id=\"login-email\"]";
        String pwd = "!qaz@wsx";
        String pxdXpath = "//*[@id=\"login-password\"]";
        String buttonXpath = "//*[@id=\"login-submit\"]";
        String findLink = "https://www.linkedin.com/feed/";

        Assert.assertEquals(webDriver.getCurrentUrl(),linkSite);

        WebElement searchFieldLogin = webDriver.findElement(By.xpath(loginXpath));
        searchFieldLogin.sendKeys(login);
        WebElement searchFieldPwd = webDriver.findElement(By.xpath(pxdXpath));
        searchFieldPwd.sendKeys(pwd);
        WebElement searchFieldButton = webDriver.findElement(By.xpath(buttonXpath));
        searchFieldButton.click();

        sleep(3000);

        Assert.assertEquals(webDriver.getCurrentUrl(),findLink, "You open general page from your account.");

        webDriver.quit();

    }

}
