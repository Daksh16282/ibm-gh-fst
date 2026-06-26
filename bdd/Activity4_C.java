package stepDefinitions;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.*;

public class Activity4_C extends BaseClass{

    //The given and submit button definition comes from activity 2,else give duplication error
    @When("the user enters {string} and {string}")
    public void user_enter_credentials(String username, String password){
        WebElement userField = driver.findElement(By.id("username"));
        WebElement passField = driver.findElement(By.id("password"));
        userField.sendKeys(username);
        passField.sendKeys(password);
    }

    @Then("get the confirmation text and verify message as {string}")
    public void validate_confirmation_message(String message){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2")));
        WebElement resultText = driver.findElement(By.xpath("//h2"));
        assertEquals(message, resultText.getText());
    }
    
}
