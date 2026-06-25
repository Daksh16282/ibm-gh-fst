// package stepDefinitions;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;

// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;

// public class Activity2_C extends BaseClass{
    
//     @Given("the user is on the login page")
//     public void user_on_login_page(){
//         driver.get("https://training-support.net/webelements/login-form");
//     }

//     @When("the user enters username and password")
//     public void user_enter_credentials(){
//         WebElement userField = driver.findElement(By.id("username"));
//         WebElement passField = driver.findElement(By.id("password"));
//         userField.sendKeys("admin");
//         passField.sendKeys("password");
//     }

//     @And("clicks the submit button")
//     public void click_submit_button(){
//         WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
//         submitButton.click();
//     }

//     @Then("get the confirmation message and verify it")
//     public void validate_confirmation_message(){
//         wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2")));
//         WebElement resultText = driver.findElement(By.xpath("//h2"));
//         assertEquals("Welcome Back, Admin!", resultText.getText());
//     }
// }
