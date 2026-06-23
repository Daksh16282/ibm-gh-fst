import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity15 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/dynamic-attributes");
        System.out.println("Title of page is : " + webDriver.getTitle());
        WebElement nameField = webDriver.findElement(By.xpath("//input[contains(@id,'full-name-')]"));
        WebElement emailField = webDriver.findElement(By.xpath("//input[contains(@id,'-email')]"));
        WebElement dateField = webDriver.findElement(By.xpath("//input[contains(@name,'-event-date-')]"));
        WebElement additionalField = webDriver.findElement(By.xpath("//textarea[contains(@id,'additional-details')]"));
        WebElement submitButtton = webDriver.findElement(By.xpath("//button[text()='Submit']"));

        nameField.sendKeys("Verma");
        emailField.sendKeys("vrm@gmail.com");
        // Actual acceptable format yyyy/mm/dd
        dateField.sendKeys("2026-06-23");
        additionalField.sendKeys("Nothing..");
        submitButtton.click();

        WebElement successMessage = webDriver.findElement(By.id("action-confirmation"));
        System.out.println("Message : " + successMessage.getText());
        webDriver.quit();
    }
}
