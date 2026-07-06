package appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

    AndroidDriver androidDriver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        options.noReset();

        URL url = new URI("http://127.0.0.1:4723").toURL();
        androidDriver = new AndroidDriver(url, options);
    }

    @Test
    public void addition() {
        WebElement clear = androidDriver.findElement(AppiumBy.id("clr"));
        clear.click();
        WebElement five = androidDriver.findElement(AppiumBy.id("digit_5"));
        five.click();
        WebElement plus = androidDriver.findElement(AppiumBy.id("op_add"));
        plus.click();
        WebElement nine = androidDriver.findElement(AppiumBy.id("digit_9"));
        nine.click();
        WebElement equals = androidDriver.findElement(AppiumBy.id("eq"));
        equals.click();
        WebElement resultText = androidDriver.findElement(AppiumBy.id("result_final"));
        System.out.println("Result of 5+9 is : " + resultText.getText());
        Assert.assertEquals(resultText.getText(), "14");
    }

    @Test
    public void subtraction() {
        WebElement clear = androidDriver.findElement(AppiumBy.id("clr"));
        clear.click();
        WebElement one = androidDriver.findElement(AppiumBy.id("digit_1"));
        one.click();
        WebElement zero = androidDriver.findElement(AppiumBy.id("digit_0"));
        zero.click();
        WebElement minus = androidDriver.findElement(AppiumBy.id("op_sub"));
        minus.click();
        WebElement five = androidDriver.findElement(AppiumBy.id("digit_5"));
        five.click();
        WebElement equals = androidDriver.findElement(AppiumBy.id("eq"));
        equals.click();
        WebElement resultText = androidDriver.findElement(AppiumBy.id("result_final"));
        System.out.println("Result of 10-5 is : " + resultText.getText());
        Assert.assertEquals(resultText.getText(), "5");
    }

    @Test
    public void multiplication() {
        WebElement clear = androidDriver.findElement(AppiumBy.id("clr"));
        clear.click();
        WebElement five = androidDriver.findElement(AppiumBy.id("digit_5"));
        five.click();
        WebElement multiply = androidDriver.findElement(AppiumBy.id("op_mul"));
        multiply.click();
        WebElement one = androidDriver.findElement(AppiumBy.id("digit_1"));
        one.click();
        WebElement zero = androidDriver.findElement(AppiumBy.id("digit_0"));
        zero.click();
        zero.click();
        WebElement equals = androidDriver.findElement(AppiumBy.id("eq"));
        equals.click();
        WebElement resultText = androidDriver.findElement(AppiumBy.id("result_final"));
        System.out.println("Result of 5*100 is : " + resultText.getText());
        Assert.assertEquals(resultText.getText(), "500");
    }

    @Test
    public void divide() {
        WebElement clear = androidDriver.findElement(AppiumBy.id("clr"));
        clear.click();
        WebElement five = androidDriver.findElement(AppiumBy.id("digit_5"));
        five.click();
        WebElement zero = androidDriver.findElement(AppiumBy.id("digit_0"));
        zero.click();
        WebElement divide = androidDriver.findElement(AppiumBy.id("op_div"));
        divide.click();
        WebElement two = androidDriver.findElement(AppiumBy.id("digit_2"));
        two.click();
        WebElement equals = androidDriver.findElement(AppiumBy.id("eq"));
        equals.click();
        WebElement resultText = androidDriver.findElement(AppiumBy.id("result_final"));
        System.out.println("Result of 50/2 is : " + resultText.getText());
        Assert.assertEquals(resultText.getText(), "25");
    }

    @AfterClass
    public void tearDown() {
        androidDriver.quit();
    }

}
