package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

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

public class SearchTest extends BaseTest{

    @Test
    public void basicSearchTest() {
        //String searchTerm = "HR";

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        HomePage homePage = loginPage.login("SergAutoTest@bigmir.net","!qaz@wsx");

        Assert.assertTrue(homePage.isPageLoaded(),"page.HomePage is not displayed on Login Page!");

//        page.SearchPage searchPage = page.HomePage.search(searchTerm);
//        Assert.assertTrue(searchPage.isPageLoaded(),"Search page is not displayed on Login Page!");
//        Assert.assertEquals(searchPage.getSearchResultsCount(),10,"Search result count is wrong.");
//
//        Assert.assertTrue(searchPage.getSearchResults().contains(searchTerm));
//
//
//
//
//        WebElement searchField = webDriver.findElement(By.xpath("/html/body/nav/div/form/div/div/div/artdeco-typeahead-deprecated/artdeco-typeahead-deprecated-input/input"));
//        searchField.sendKeys(searchTerm);
//        searchField.sendKeys(Keys.RETURN);
//
//        sleep(5000);
//
//        page.SearchPage searchPage = new page.SearchPage(webDriver);
//        Assert.assertTrue(searchPage.isPageLoaded(),"page.SearchPage page is not loaded!" );
//        sleep(5000);
//        searchPage.printSearchResult(searchTerm);


    }
}
