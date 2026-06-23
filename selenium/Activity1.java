import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net");

        String titleString = webDriver.getTitle();
        System.out.println("Title is : " + titleString);

        WebElement buttonElement = webDriver.findElement(By.linkText("About Us"));
        buttonElement.click();
        System.out.println("Title of new page after clicking about us is : " + webDriver.getTitle());

        webDriver.quit();

    }
}
