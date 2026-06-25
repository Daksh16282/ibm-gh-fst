package stepDefinitions;

import io.cucumber.java.en.Given;

public class Activity2_step1 extends BaseClass {
      @Given("the user is on the login page")
    public void user_on_login_page(){
        driver.get("https://training-support.net/webelements/login-form");
    }
}
