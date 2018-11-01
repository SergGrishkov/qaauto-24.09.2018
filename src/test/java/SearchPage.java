import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@class=\"neptune-grid\"]")
    private WebElement allFilter;

    @FindBy(xpath = "\"/html/body/nav/div/form/div/div/div/artdeco-typeahead-deprecated/artdeco-typeahead-deprecated-input/input\"")
    private WebElement searchField;

    public SearchPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSignInButtonDisplay(){
        return allFilter.isDisplayed();
    }


    public boolean isPageLoaded (){
        return webDriver.getCurrentUrl().contains("keywords=HR&origin=GLOBAL_SEARCH_HEADER")
                && webDriver.getTitle().contains("Поиск | LinkedIn")
                && isSignInButtonDisplay();
    }

    public void printSearchResult (String searchTerm) throws InterruptedException {
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//*[@class='search-result__wrapper']"));
        sleep(5000);
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
