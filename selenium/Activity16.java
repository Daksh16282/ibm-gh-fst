import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/selects");
        System.out.println("Title of page is : " + webDriver.getTitle());

        WebElement selectElement = webDriver.findElement(By.tagName("select"));

        // Create select object
        Select select = new Select(selectElement);
        select.selectByContainsVisibleText("Two");
        // Actual 0-based indexing but act as 1-based as 'select option' will not be
        // counted
        select.selectByIndex(3);
        select.selectByValue("four");

        System.out.println("Available options are :- ");
        List<WebElement> options = select.getOptions();
        for (WebElement webElement : options) {
            System.out.println(webElement.getText());
        }
        webDriver.quit();
    }
}
