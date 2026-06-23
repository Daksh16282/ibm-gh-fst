import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/login-form/");
        System.out.println("Title of page is : " + webDriver.getTitle());
        WebElement userName = webDriver.findElement(By.name("username"));
        userName.sendKeys("admin");
        WebElement password = webDriver.findElement(By.name("password"));
        password.sendKeys("password");
        WebElement logInButton = webDriver
                .findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button"));
        logInButton.click();

        String messageString = webDriver.findElement(By.tagName("h1")).getText();
        System.out.println(messageString);
        webDriver.quit();
    }
}
