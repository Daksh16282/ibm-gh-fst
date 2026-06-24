import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity21 {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/tabs");
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        System.out.println("Title of current page is : " + webDriver.getTitle());

        String tab1Handle = webDriver.getWindowHandle();
        WebElement newTabButton = webDriver.findElement(By.xpath("//button[text()='Open A New Tab']"));
        newTabButton.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        System.out.println("Available handles are :- ");
        Set<String> allHandles = webDriver.getWindowHandles();
        for (String handleString : allHandles) {
            System.out.print(handleString + " ");
            if (handleString != tab1Handle) {
                webDriver.switchTo().window(handleString);
            }
        }
        System.out.println();
        System.out.println("Title of tab 2 is : " + webDriver.getTitle());
        String message2 = webDriver.findElement(By.xpath("//h2")).getText();
        System.out.println("Message of tab 2 is : " + message2);

        // Repeating secod time
        String tab2Handle = webDriver.getWindowHandle();
        WebElement anotherTabButton = webDriver.findElement(By.xpath("//button[text()='Open Another One']"));
        anotherTabButton.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        System.out.println("Available handles are :- ");
        Set<String> allHandles2 = webDriver.getWindowHandles();
        for (String handleString : allHandles2) {
            System.out.print(handleString + " ");

            // We can also fetch as
            // for (String handle : driver.getWindowHandles()) {
            // driver.switchTo().window(handle);
            // } as set is ordered and we will get latest at end
            if (handleString != tab1Handle && handleString != tab2Handle) {
                webDriver.switchTo().window(handleString);
            }
        }
        System.out.println();
        System.out.println("Title of tab 3 is : " + webDriver.getTitle());
        String message3 = webDriver.findElement(By.xpath("//h2")).getText();
        System.out.println("Message of tab 3 is : " + message3);

        webDriver.quit();
    }
}
