import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/selects");
        System.out.println("Title of page is : " + webDriver.getTitle());

        WebElement selectElement = webDriver.findElement(By.xpath("//select[@multiple='']"));

        Select select = new Select(selectElement);

        // Here 0-based as no 'select option'
        // As 0 got selected by default
        select.deselectByIndex(0);
        select.selectByVisibleText("HTML");
        select.selectByIndex(3);
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByValue("nodejs");
        select.deselectByIndex(4);
        webDriver.quit();

    }
}
