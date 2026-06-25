package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

public class Activity2_step3 extends BaseClass{
     @And("clicks the submit button")
    public void click_submit_button(){
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();
    }

}
