import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@class=\"neptune-grid\"]")
    private WebElement allFilter;

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

}
