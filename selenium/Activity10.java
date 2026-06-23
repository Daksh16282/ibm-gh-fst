import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10 {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriver.get("https://training-support.net/webelements/mouse-events");

        WebElement cargoLock = webDriver.findElement(By.xpath("//h1[text() = 'Cargo.lock']"));
        WebElement cargoToml = webDriver.findElement(By.xpath("//h1[text() = 'Cargo.toml']"));
        WebElement src = webDriver.findElement(By.xpath("//h1[text() = 'src']"));
        WebElement target = webDriver.findElement(By.xpath("//h1[text() = 'target']"));

        Actions builderActions = new Actions(webDriver);

        Action leftClickCargoLock = builderActions.click(cargoLock).pause(2000).build();
        Action moveToCargoToml = builderActions.moveToElement(cargoToml).click().pause(2000).build();
        Action doubleClickSrc = builderActions.doubleClick(src).pause(2000).build();
        Action rightClickTarget = builderActions.contextClick(target).pause(2000).build();

        By paragraphId = By.id("result");

        leftClickCargoLock.perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paragraphId));
        WebElement result = webDriver.findElement(paragraphId);
        System.out.println("Message is : " + result.getText());

        moveToCargoToml.perform();
        System.out.println("Message is : " + result.getText());

        doubleClickSrc.perform();
        System.out.println("Message is : " + result.getText());

        rightClickTarget.perform();
        By openOption = By.xpath("//button/span[text()='Open']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(openOption));
        WebElement openButton = webDriver.findElement(openOption);
        Action openButtonClicked = builderActions.click(openButton).pause(2000).build();
        openButtonClicked.perform();
        System.out.println("Message is : " + result.getText());

        webDriver.quit();
    }

}
