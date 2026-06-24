package TestNG;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5_Test {
    WebDriver webDriver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/target-practice");
    }

    // When even one is excluded in test suite,still function is not executed
    // because of the effect
    // but even if one is included in test suite,the function will run because of
    // include effect
    // If one is excluded and one is included still works
    @Test(groups = { "Header_Test", "Button_Test" })
    public void testAPageTitle() {
        assertEquals(webDriver.getTitle(), "Selenium: Target Practice");
    }

    @Test(groups = { "Header_Test" }, dependsOnMethods = { "testAPageTitle" })
    public void testBHeader3Text() {
        WebElement header3 = webDriver.findElement(By.xpath("//h3[@class='text-3xl font-bold text-orange-600']"));
        assertEquals(header3.getText(), "Heading #3");
    }

    @Test(groups = { "Header_Test" }, dependsOnMethods = { "testAPageTitle" })
    public void testCHeader5Color() {
        WebElement header5 = webDriver.findElement(By.xpath("//h5"));
        assertEquals(header5.getCssValue("color"), "rgb(147, 51, 234)");
    }

    @Test(groups = { "Button_Test" }, dependsOnMethods = { "testAPageTitle" })
    public void testDemeraButton() {
        WebElement emeraldButton = webDriver.findElement(By.xpath("//button[contains(@class,'emerald')]"));
        assertEquals(emeraldButton.getText(), "Emerald");
    }

    @Test(groups = { "Button_Test" }, dependsOnMethods = { "testAPageTitle" })
    public void testEfirstButton3rdRowColor() {
        WebElement button = webDriver.findElement(By.xpath("//button[text()='Purple']"));
        assertEquals(button.getCssValue("color"), "rgb(88, 28, 135)");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        webDriver.close();
    }
}
