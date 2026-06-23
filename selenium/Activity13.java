import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {
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

        System.out.println("Values of third row are :-");
        WebElement thirdRow = rows.get(2);
        // Using ./ access <td> inside of 3rd <tr> not all <td>
        List<WebElement> rowValues = thirdRow.findElements(By.xpath("./td"));
        for (WebElement webElement : rowValues) {
            System.out.print(webElement.getText() + " ");
        }
        System.out.println();
        WebElement secondRow = rows.get(1);
        WebElement cellValue = secondRow.findElement(By.xpath("./td[2]"));
        System.out.println("Value at second row second column is :- " +
                cellValue.getText());

        webDriver.quit();
    }
}
