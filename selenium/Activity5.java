import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println("Title of page is : " + webDriver.getTitle());

        WebElement checkBoxElement = webDriver.findElement(By.id("checkbox"));

        System.out.println("Is checkbox visible : " + checkBoxElement.isDisplayed());

        WebElement removeCheckBoxButton = webDriver
                .findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]"));
        removeCheckBoxButton.click();

        System.out.println("Is checkbox visible after remove checkbox clicked : " + checkBoxElement.isDisplayed());

        webDriver.quit();
    }
}
