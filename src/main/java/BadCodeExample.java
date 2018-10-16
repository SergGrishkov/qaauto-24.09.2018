import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample {

    public BadCodeExample() {
    }

    public static void main(String args []) throws InterruptedException {


        String searchTerm = "Selenium";

        System.out.println("Hello world!!");

        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to("https://www.google.com");

// Домашняя работа

        //   WebElement searchField = webDriver.findElement(By.id("lst-ib"));  правильно но можно и через xpath

        WebElement searchField = webDriver.findElement(By.xpath("//*[@id='lst-ib']"));//обявление переменной и присвоение ей значения, записана вся нода из дом структуре в переменную

        //   -- // - искать с самого верха на каждом уровне вложености
        // * -выберить все теги
        // '' - екранирование

        searchField.sendKeys(searchTerm);//правильно
        searchField.sendKeys(Keys.RETURN);//правильно, можно и enter

// на уроке 27.09.18
        sleep(3000);

        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));


        System.out.println("Search results count: "+searchResults.size());
        System.out.println();

        for (WebElement element : searchResults) {
            System.out.println("******************************************************************************");
            System.out.println(element.getText());

            if (element.getText().toLowerCase().contains(searchTerm.toLowerCase())) {
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