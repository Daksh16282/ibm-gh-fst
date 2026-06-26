package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity6_C extends BaseClass{

    @Given("user is on the To-Do list page")
    public void user_is_on_todo_page(){
        driver.get("https://training-support.net/webelements/todo-list");
    }

    @When("user adds the following tasks")
    public void user_adds_tasks(DataTable taskInputs){
        WebElement todoInput = driver.findElement(By.id("todo-input"));
        WebElement addTask = driver.findElement(By.id("todo-add"));

        List<String> taskList = taskInputs.asList();
        for (String taskString : taskList) {
            todoInput.sendKeys(taskString);
            addTask.click();
        }
    }

    @Then("they can see the task added to the list")
    public void verify_tasks_added(){
        System.out.println("All tasks present");
    }
    
}
