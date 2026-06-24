import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity20 {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/alerts");
        System.out.println("Title of page is : " + webDriver.getTitle());
        WebElement promptButton = webDriver.findElement(By.id("prompt"));
        By resultId = By.id("result");
        WebElement resultText = webDriver.findElement(resultId);
        promptButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("Awesome!");
        alert.accept();
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultId));
        System.out.println(resultText.getText());
        webDriver.quit();
    }
}
