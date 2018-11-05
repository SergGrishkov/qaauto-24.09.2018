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

//    @FindBy(xpath = "\"/html/body/nav/div/form/div/div/div/artdeco-typeahead-deprecated/artdeco-typeahead-deprecated-input/input\"")
//    private WebElement searchField;

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

//    public void printSearchResult (String searchTerm) throws InterruptedException {
//
//        List<WebElement> searchResults = webDriver.findElements(By.xpath("//*[@class='search-result__wrapper']"));
//        sleep(5000);
//        System.out.println("Size = " + searchResults.size());
//
//        for (WebElement element : searchResults) {
//
//            System.out.println("******************************************************************************");
//            System.out.println(element.getText());
//            if (element.getText().toLowerCase().contains(searchTerm.toLowerCase())){
//                System.out.println("|-----SearchTerm " + searchTerm + " was found.-----|");
//            }
//            else  {
//                System.out.println("|-----SearchTerm " + searchTerm + " was not found.-----|");
//            }
//            System.out.println("******************************************************************************");
//            System.out.println();
//        }
//
//    }

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
