package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;

public class Activity5_C extends BaseClass{
   

    //Other definitions came from from activity 2 and 4
    @Then("get the confirmation text message and verify message as {string}")
    public void validate_confirmation_message(String message){
        By headingId = By.id("subheading");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(headingId));
        WebElement resultText = driver.findElement(headingId);
        assertEquals(message, resultText.getText());
    }

  
   
}
