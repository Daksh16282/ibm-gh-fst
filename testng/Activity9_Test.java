package TestNG;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Note :- The output will be updated in index.html under test-output folder
public class Activity9_Test {
    WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/alerts");
    }

    @BeforeMethod
    public void regainFocus() {
        webDriver.switchTo().defaultContent();
    }

    @SuppressWarnings("null")
    @Test
    public void simpleAlertTestCase() {
        WebElement simpleButton = webDriver.findElement(By.id("simple"));
        By resultId = By.id("result");
        Reporter.log("Got reference of simple button");
        WebElement resultText = webDriver.findElement(resultId);
        simpleButton.click();
        Reporter.log("Simple button clicked");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        Reporter.log("Switched focus to Alert");
        Reporter.log("Alert box text is : " + alert.getText());
        alert.accept();
        Reporter.log("Alert is accepted");
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultId));
        Reporter.log(resultText.getText());
    }

    @SuppressWarnings("null")
    @Test
    public void confirmAlertTestCase() {
        WebElement confirmButton = webDriver.findElement(By.id("confirmation"));
        By resultId = By.id("result");
        Reporter.log("Got reference of confirmation button");

        WebElement resultText = webDriver.findElement(resultId);
        confirmButton.click();
        Reporter.log("Confirmation button clicked");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        Reporter.log("Switched focus to Alert");
        Reporter.log("Alert box text is : " + alert.getText());
        alert.accept();
        Reporter.log("Alert is accepted");

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultId));
        Reporter.log(resultText.getText());

        confirmButton.click();
        Reporter.log("Confirmation button clicked");
        alert.dismiss();
        Reporter.log("Alert is dismissed");

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultId));
        Reporter.log(resultText.getText());
    }

    @SuppressWarnings("null")
    @Test
    public void promptAlertTestCase() {
        WebElement promptButton = webDriver.findElement(By.id("prompt"));
        By resultId = By.id("result");
        Reporter.log("Got reference of prompt button");

        WebElement resultText = webDriver.findElement(resultId);
        promptButton.click();
        Reporter.log("Prompt button clicked");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        Reporter.log("Switched focus to Alert");

        Reporter.log("Alert box text is : " + alert.getText());

        alert.sendKeys("Awesome!");
        Reporter.log("Sent input text to prompt field");
        alert.accept();
        Reporter.log("Alert is accepted");

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultId));
        Reporter.log(resultText.getText());
    }

    @AfterClass
    public void tearDown() {
        webDriver.close();
    }
}
