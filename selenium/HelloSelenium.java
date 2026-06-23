import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium {
  public static void main(String[] args) {
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();

    // Open the browser
    driver.get("https://training-support.net");

    // Perform Testing and assertion
    System.out.println(driver.getTitle());

    // Close the browser
    driver.quit();
  }
}