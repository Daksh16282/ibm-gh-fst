package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity3_C extends BaseClass{

    Alert alert;

    @Given("User is on the page")
    public void user_is_on_page(){
        driver.get("https://training-support.net/webelements/alerts");
    }

    @When("User clicks the Simple Alert button")
    public void click_simple_button(){
        WebElement simpleButton = driver.findElement(By.id("simple"));
        simpleButton.click();
    }
    
    @When("User clicks the Confirm Alert button")
    public void click_confirm_button(){
        WebElement confirmationButton = driver.findElement(By.id("confirmation"));
        confirmationButton.click();
    }
    @When("User clicks the Prompt Alert button")
    public void click_prompt_button(){
        WebElement promptButton = driver.findElement(By.id("prompt"));
        promptButton.click();
    }

    @Then("Alert opens")
    public void alert_opens(){
      alert =   driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void readAlertText(){
        System.out.println(alert.getText());
    }

    @And("Write a custom message in it")
    public void write_custom_message(){
        alert.sendKeys("Awesome!");
    }

    @And("Close the alert")
    public void close_alert(){
        alert.accept();
    }
    
    @And("Close the alert with Cancel")
    public void close_alert_with_cancel(){
        alert.accept();
    }

    @And("Read the result text")
    public void read_result_text(){
        By resultId = By.id("result");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultId));
        System.out.println(driver.findElement(resultId).getText());
    }

    
}
