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

        Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded!");
        HomePage homePage = loginPage.login("SergAutoTest@bigmir.net","!qaz@wsx");

        Assert.assertTrue(homePage.isPageLoaded(),"page.HomePage is not displayed on Login Page!");

    }
}
