import org.openqa.selenium.*;
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

        SearchPage searchPage = HomePage.search(searchTerm);
        Assert.assertTrue(searchPage.isPageLoaded(),"Search page is not displayed on Login Page!");
        Assert.assertEquals(searchPage.getSearchResultsCount(),10,"Search result count is wrong.");

        Assert.assertTrue(searchPage.getSearchResults().contains(searchTerm));




        WebElement searchField = webDriver.findElement(By.xpath("/html/body/nav/div/form/div/div/div/artdeco-typeahead-deprecated/artdeco-typeahead-deprecated-input/input"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);

        sleep(5000);

        SearchPage searchPage = new SearchPage(webDriver);
        Assert.assertTrue(searchPage.isPageLoaded(),"SearchPage page is not loaded!" );
        sleep(5000);
        searchPage.printSearchResult(searchTerm);


    }
}
