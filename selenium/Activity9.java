import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9 {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

        webDriver.get("https://training-support.net/webelements/dynamic-content");

        System.out.println("Title of page is : " + webDriver.getTitle());

        WebElement clickMeButton = webDriver.findElement(By.id("genButton"));
        clickMeButton.click();

        By releaseWordPath = By.xpath("//h2[text() = 'release']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseWordPath));

        String releaseText = webDriver.findElement(releaseWordPath).getText();
        System.out.println("Text is : " + releaseText);

        webDriver.quit();
    }
}
