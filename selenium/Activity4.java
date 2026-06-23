import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://training-support.net/webelements/target-practice");
        System.out.println("Title of page is : " + webDriver.getTitle());

        WebElement header3 = webDriver.findElement(By.xpath("//h3"));
        System.out.println("Text of third header : " + header3.getText());

        WebElement header5 = webDriver.findElement(By.xpath("//h5"));
        System.out.println("Color of 5th header : " + header5.getCssValue("color"));

        WebElement purpleButton = webDriver.findElement(By.xpath("//button[contains(@class,'bg-purple-200')]"));
        System.out.println("Purple Button classes : " + purpleButton.getAttribute("class"));

        WebElement slateButton = webDriver.findElement(By.xpath("//button[contains(@class,'text-slate-900')]"));
        System.out.println("Slate button text : " + slateButton.getText());

        webDriver.quit();
    }
}
