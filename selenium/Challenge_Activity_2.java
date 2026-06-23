package Challenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Challenge_Activity_2 {
    @SuppressWarnings("null")
    public static void main(String[] args) {

        WebDriver webDriver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        webDriver.get(
                "https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_6o3s351fev_e&adgrpid=150668181581&hvpone=&hvptwo=&hvadid=809058944351&hvpos=&hvnetw=g&hvrand=4923055548971289360&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062044&hvtargid=kwd-300061672064&hydadcr=5621_2499480&gad_source=1");

        By searchBarId = By.xpath("//input[@id='twotabsearchtextbox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarId));

        WebElement searchBar = webDriver.findElement(searchBarId);

        searchBar.sendKeys("IPhone 17 Pro");

        By searchButtonId = By.xpath("//input[@id='nav-search-submit-button']");
        WebElement searchButton = webDriver.findElement(searchButtonId);
        searchButton.click();

        By priceId = By.xpath(
                "(//span[@class = 'a-price-whole'])[4]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceId));

        WebElement price = webDriver.findElement(priceId);

        System.out.println("Price is : " + price.getText());
        webDriver.quit();
    }

    // Version without wait implemented,here sometimes it works and sometimes not
    // public static void main(String[] args) {
    // WebDriver webDriver = new FirefoxDriver();
    // webDriver.get(
    // "https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_6o3s351fev_e&adgrpid=150668181581&hvpone=&hvptwo=&hvadid=809058944351&hvpos=&hvnetw=g&hvrand=4923055548971289360&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062044&hvtargid=kwd-300061672064&hydadcr=5621_2499480&gad_source=1");
    // WebElement searchBar =
    // webDriver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    // searchBar.sendKeys("IPhone 17 Pro");

    // WebElement searchButton =
    // webDriver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
    // searchButton.click();

    // // WebElement price = webDriver.findElement(By.xpath(
    // //
    // "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]"));

    // WebElement price = webDriver.findElement(By.xpath(
    // "//span[@class = 'a-price-whole'][4]"));

    // System.out.println("Price is : " + price.getText());
    // webDriver.quit();
    // }

}
