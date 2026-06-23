package Challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Challenge_Activity_1 {

    public static void main(String[] args) {

        // Connect with Firefox
        WebDriver webDriver = new FirefoxDriver();
        // Open URL
        webDriver.get("https://www.google.com");
        // Get specific element
        WebElement webElement = webDriver.findElement(By.id("APjFqb"));
        // Fetch attributes of element and print them
        String classVal = webElement.getAttribute("class");
        String idVal = webElement.getAttribute("id");
        String nameVal = webElement.getAttribute("name");

        System.out.println("Name = " + nameVal + " Class = " + classVal + " Id = " + idVal);

        // Close the browser
        webDriver.quit();
    }
}
