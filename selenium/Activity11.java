
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity11 {

    @SuppressWarnings("null")
    public static void main(String[] args) {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/keyboard-events");
        System.out.println("Title of page is : " + webDriver.getTitle());

        Actions builder = new Actions(webDriver);
        // Type to default focused element and use Enter to avoid pause as it will
        // update the value
        Action type = builder.sendKeys("From Selenium").sendKeys(Keys.ENTER).build();

        type.perform();

        By typedTextPath = By.xpath("//h1[@class = 'mt-3 text-4xl font-semibold text-center text-black']");

        WebElement typedText = webDriver.findElement(typedTextPath);
        System.out.println(typedText.getText());
        webDriver.quit();
    }
}