package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class SearchPage extends BasePage{


    @FindBy(xpath = "//div[contains(@class,'search-filters-bar')]")
    private WebElement searchBar;


    @FindBy(xpath = "//li[contains(@class,'search-result__occluded-item')]")
    private List<WebElement> searchResultList;

    public SearchPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    private boolean isSignInBarDisplay(){
        return searchBar.isDisplayed();
    }


    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().contains("search/results")
                && webDriver.getTitle().contains("Поиск | LinkedIn")
                && isSignInBarDisplay();
    }


    public int getSearchResultsCount() {
        return searchResultList.size();
    }

    public List<String> getSearchResults() {
        List<String> searchResultStringList = new ArrayList<String>();
        for (WebElement searchResult : searchResultList) {
            String searchResultText = searchResult.getText();
            searchResultStringList.add(searchResultText);
        }
        return searchResultStringList;
    }
}
