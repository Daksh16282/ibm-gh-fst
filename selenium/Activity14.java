import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity14 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/tables");
        System.out.println("Title of page is : " + webDriver.getTitle());

        // Get All rows
        List<WebElement> rows = webDriver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("No of rows are : " + rows.size());

        // Get All columns
        List<WebElement> columns = webDriver.findElements(By.xpath("//table/tbody/tr[1]/td"));
        System.out.println("No of columns are : " + columns.size());

        WebElement fifthRow = rows.get(4);
        // Before Sorting
        WebElement bookValue = fifthRow.findElement(By.xpath("./td[2]"));
        System.out.println("Book on 5th row is :- " + bookValue.getText());

        WebElement priceHeader = webDriver.findElement(By.xpath("//table/thead/tr/th[5]"));
        Actions builder = new Actions(webDriver);

        Action clickPriceHeader = builder.click(priceHeader).pause(5000).build();
        clickPriceHeader.perform();

        // Refetch reference, depends on page( as the page is reloaded here,so its like
        // a new table )
        bookValue = webDriver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
        System.out.println("Book on 5th row after sorting according to price is :- " + bookValue.getText());

        webDriver.quit();
    }
}
