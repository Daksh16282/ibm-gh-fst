package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2_Test {
    WebDriver webDriver;

    @BeforeClass
    public void initiateDriver() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/target-practice");
    }

    @Test
    public void avalidateTitle() {
        String titleActual = webDriver.getTitle();
        System.out.println("Title actual title is : " + titleActual);
        String titleExpected = "Selenium: Target Practice";
        assertEquals(titleActual, titleExpected);
    }
    @Test
    public void bvalidateBlackButton() {
        WebElement blackElement = webDriver.findElement(By.id("black-button"));
        assertEquals("Black", blackElement.getText());
    }

    // Doesn't even counted
    @Test(enabled = false)
    public void cvalidateSkip() {
        System.out.println("Skipping test");
    }

    @Test
    public void dvalidateSkipWithException() {
        throw new SkipException("Simulating skip Exception");
    }

    @AfterClass
    public void closeBrowser() {
        webDriver.close();
    }
}
