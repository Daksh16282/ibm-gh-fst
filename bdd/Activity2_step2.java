package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class Activity2_step2 extends BaseClass{
    @When("the user enters username and password")
    public void user_enter_credentials(){
        WebElement userField = driver.findElement(By.id("username"));
        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys("admin");
        passField.sendKeys("password");
    }
}
