import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Precondition:
 * - Open new Browser.
 * - Navigate to Linkedin.com
 *
 * Scenario:
 *  - Verify that login page is loaded.
 *  - Login with valid credentials.
 *  - Verify that Home page is loaded.
 *  - Enter 'searchTerms' into search field and press RETURN key.
 *  - Verify that Search page is loaded.
 *  - Verify 10 searchResults displayed on page.
 *  - Verify each result item contains 'searchTerms'.
 *
 *  Postcondition:
 *  - Close Browser.
 */

public class SearchTest {
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



    @Test
    public void basicSearchTest() throws InterruptedException {
        String searchTerm = "HR";

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        HomePage homePage = loginPage.login("SergAutoTest@bigmir.net","!qaz@wsx");
        Assert.assertTrue(homePage.isPageLoaded(),"HomePage is not displayed on Login Page!");

        WebElement searchField = webDriver.findElement(By.xpath("/html/body/nav/div/form/div/div/div/artdeco-typeahead-deprecated/artdeco-typeahead-deprecated-input/input"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);

        sleep(30000);

        SearchPage searchPage = new SearchPage(webDriver);
        Assert.assertTrue(searchPage.isPageLoaded(),"SearchPage page is not loaded!" );

        List <WebElement> searchResults = webDriver.findElements(By.xpath("//*[@class='search-result__wrapper']"));
        sleep(3000);

        Assert.assertEquals(searchResults.size(), 10, "Total resuln <> 10.");
        System.out.println("Size = " + searchResults.size());

        for (WebElement element : searchResults) {
            System.out.println("******************************************************************************");
            System.out.println(element.getText());
            if (element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
                System.out.println("|-----SearchTerm " + searchTerm + " was found.-----|");
            }
            else  {
                System.out.println("|-----SearchTerm " + searchTerm + " was not found.-----|");
            }
            System.out.println("******************************************************************************");
            System.out.println();
        }
    }
}
