import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

    @SuppressWarnings("null")
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/dynamic-controls");
        System.out.println("Title of page is " + webDriver.getTitle());

        WebElement checkBox = webDriver.findElement(By.id("checkbox"));
        WebElement toggleButton = webDriver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']"));
        toggleButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

        toggleButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

        checkBox.click();

        webDriver.quit();
    }
}
