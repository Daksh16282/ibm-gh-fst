package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1_Test {

    WebDriver webDriver;

    @BeforeClass
    public void initiateDriver() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/");
    }

    // Named as testA as to run it first alphabetically
    @Test
    public void testATitle() {
        String titleActual = webDriver.getTitle();
        System.out.println("Title actual title is : " + titleActual);
        String titleExpected = "Training Support";
        assertEquals(titleActual, titleExpected);
    }

    @Test
    public void testBAboutUsitle() {
        WebElement aboutUsButton = webDriver.findElement(By.xpath("//a[text()='About Us']"));
        aboutUsButton.click();
        String titleExpected = webDriver.getTitle();
        System.out.println("Title expected is : " + titleExpected);
        String titleActual = "About Training Support";
        assertEquals(titleExpected, titleActual);
    }

    @AfterClass
    public void closeBrowser() {
        webDriver.quit();
    }
}
