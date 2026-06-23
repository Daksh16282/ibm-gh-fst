import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/dynamic-controls");
        WebElement textFieldElement = webDriver.findElement(By.id("textInput"));
        System.out.println("Is textfield enabled : " + textFieldElement.isEnabled());

        WebElement enableInputButton = webDriver.findElement(By.id("textInputButton"));
        enableInputButton.click();

        System.out.println("Is textfield enabled after clicking enable input button : " + textFieldElement.isEnabled());

        webDriver.quit();
    }
}
