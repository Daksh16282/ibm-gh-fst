import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println("Title of page is : " + webDriver.getTitle());

        WebElement checkBoxElement = webDriver.findElement(By.id("checkbox"));
        System.out.println("Is checkbox selected : " + checkBoxElement.isSelected());

        checkBoxElement.click();

        System.out.println("Is checkbox selected after clicked : " + checkBoxElement.isSelected());

        webDriver.quit();
    }

}
