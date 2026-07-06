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

public class Activity2 {
    // Driver Declaration
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        // Path where calculator.apk is present on PC
        // or package name & activity name if already
        // installed on device
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        // options.setApp("C:/Users/DakshVerma/QE/calculator.apk");
        options.noReset();

        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        // open page in chrome
        driver.get("https://training-support.net");
    }

    @Test
    public void printHeadingFromBrowser() {

        String pageHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']"))
                .getText();

        System.out.println("Page heading is : " + pageHeading);

        WebElement aboutUsButton = driver.findElement(AppiumBy.accessibilityId("About Us"));
        aboutUsButton.click();
        String aboutUsText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']"))
                .getText();
        System.out.println("About Us page text is : " + aboutUsText);

        Assert.assertEquals(pageHeading, "Training Support");
        Assert.assertEquals(aboutUsText, "About Us");

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
