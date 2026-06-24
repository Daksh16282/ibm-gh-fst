import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/popups");
        System.out.println("Title of page is : " + webDriver.getTitle());
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement openPopUp = webDriver.findElement(By.id("launcher"));
        openPopUp.click();
        By formId = By.id("signInForm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(formId));
        WebElement userField = webDriver.findElement(By.id("username"));
        WebElement passwordField = webDriver.findElement(By.id("password"));
        WebElement submitButton = webDriver.findElement(By.xpath("//button[text()='Submit']"));

        userField.sendKeys("admin");
        passwordField.sendKeys("password");
        submitButton.click();

        By messagePart1Id = By.xpath("//h1");
        By messagePart2Id = By.xpath("//h2");

        wait.until(ExpectedConditions.visibilityOfElementLocated(messagePart1Id));
        wait.until(ExpectedConditions.visibilityOfElementLocated(messagePart2Id));

        WebElement messagePart1 = webDriver.findElement(messagePart1Id);
        WebElement messagePart2 = webDriver.findElement(messagePart2Id);

        System.out.println("Message is : " + messagePart1.getText() + " , " + messagePart2.getText());

        webDriver.quit();
    }
}
