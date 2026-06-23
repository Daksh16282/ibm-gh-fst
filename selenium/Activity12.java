import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity12 {
    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/drag-drop");
        System.out.println("Title is : " + webDriver.getTitle());

        WebElement ball = webDriver.findElement(By.id("ball"));
        WebElement dropzone1 = webDriver.findElement(By.id("dropzone1"));
        WebElement dropzone2 = webDriver.findElement(By.id("dropzone2"));

        Actions buildActions = new Actions(webDriver);
        // Drop Method 1
        Action dropBallto1 = buildActions.clickAndHold(ball).moveToElement(dropzone1).release().build();
        // Drop Method 2
        Action dropBallto2 = buildActions.dragAndDrop(ball, dropzone2).build();

        WebElement dropZone1Text = webDriver.findElement(By.xpath("//div[@id='dropzone1']/span"));
        System.out.println("Zone 1 title before dropping : " + dropZone1Text.getText());
        dropBallto1.perform();
        System.out.println("Zone 1 title after dropping : " + dropZone1Text.getText());

        WebElement dropZone2Text = webDriver.findElement(By.xpath("//div[@id='dropzone2']/span"));
        System.out.println("Zone 2 title before dropping : " + dropZone2Text.getText());
        dropBallto2.perform();
        System.out.println("Zone 2 title after dropping : " + dropZone2Text.getText());

        webDriver.quit();
    }
}
