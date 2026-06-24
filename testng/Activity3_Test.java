package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3_Test {
    WebDriver webDriver;

    @BeforeClass
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/login-form");
    }

    @Test
    public void testLogIn() {
        WebElement userField = webDriver.findElement(By.id("username"));
        WebElement passField = webDriver.findElement(By.id("password"));
        WebElement submitButton = webDriver.findElement(By.xpath("//button[text()='Submit']"));

        userField.sendKeys("admin");
        passField.sendKeys("password");
        submitButton.click();

        WebElement successMessage = webDriver.findElement(By.xpath("//h2"));
        String actual = successMessage.getText();
        String expected = "Welcome Back, Admin!";
        assertEquals(expected, actual);
    }

    @AfterClass
    public void tearDown() {
        webDriver.close();
    }

}
