package appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

        AndroidDriver androidDriver;
        WebDriverWait wait;

        @BeforeClass
        public void setUp() throws MalformedURLException, URISyntaxException {

                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("android");
                options.setAutomationName("UiAutomator2");
                options.setAppPackage("com.google.android.contacts");
                options.setAppActivity("com.android.contacts.activities.PeopleActivity");
                options.noReset();

                URL url = new URI("http://127.0.0.1:4723").toURL();
                androidDriver = new AndroidDriver(url, options);
                wait = new WebDriverWait(androidDriver, Duration.ofSeconds(5));
        }

        @Test
        public void addContact() {

                wait.until(ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(AppiumBy.accessibilityId("Create contact")));
                WebElement addContact = androidDriver.findElement(AppiumBy.accessibilityId("Create contact"));
                addContact.click();

                WebElement firstName = androidDriver
                                .findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']"));
                firstName.sendKeys("Aaditya");

                WebElement lastName = androidDriver
                                .findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']"));
                lastName.sendKeys("Varma");
                WebElement phoneNumber = androidDriver
                                .findElement(AppiumBy
                                                .xpath("//android.widget.EditText[@text='+1']"));
                phoneNumber.sendKeys("999148292");

                WebElement saveButton = androidDriver
                                .findElement(AppiumBy.xpath(
                                                "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[4]/android.widget.Button"));
                saveButton.click();

                wait.until(ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(AppiumBy.id("large_title")));
                String savedName = androidDriver.findElement(AppiumBy.id("large_title")).getText();

                Assert.assertEquals(savedName, "Aaditya Varma");

        }

        @AfterClass
        public void tearDown() {
                androidDriver.terminateApp("com.google.android.contacts");
                androidDriver.close();
        }

}
