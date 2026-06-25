package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;

public class Activity2_step4 extends BaseClass{
     @Then("get the confirmation message and verify it")
    public void validate_confirmation_message(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2")));
        WebElement resultText = driver.findElement(By.xpath("//h2"));
        assertEquals("Welcome Back, Admin!", resultText.getText());
    }
}
