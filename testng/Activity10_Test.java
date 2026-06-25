package TestNG;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity10_Test {

    WebDriver webDriver;
    WebDriverWait wait;
    CSVReader csvReader;

    @SuppressWarnings("null")
    @BeforeClass
    public void setUp() {
        webDriver = new FirefoxDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        try {
            csvReader = new CSVReader(new FileReader("src/test/resources/formData.csv"));
        } catch (FileNotFoundException e) {
            Reporter.log("CSV File Not Found |");
        }
        webDriver.get("https://training-support.net/webelements/simple-form");
    }

    @DataProvider(name = "Event_Details")
    public Object[][] dataProvider() {
        try {
            List<String[]> csvData = csvReader.readAll();
            System.out.println("Rows -> " + csvData.size() + " columns -> " + csvData.get(0).length);
            if (csvData.size() > 0) {
                Object[][] inputData = new Object[csvData.size() - 1][csvData.get(0).length];
                // Start from i=1 to skip column headers
                for (int i = 1; i <= inputData.length; i++) {
                    for (int j = 0; j < inputData[0].length; j++) {
                        System.out.println("Value is : " + csvData.get(i)[j]);
                        // use i-1 as i starts from 0
                        inputData[i - 1][j] = csvData.get(i)[j];
                    }
                }
                for (int i = 0; i < inputData.length; i++) {
                    for (int j = 0; j < inputData[0].length; j++) {
                        System.out.print(inputData[i][j] + ", ");
                    }
                }
                if (inputData.length == 0) {
                    throw new Exception("Data not formed");
                }
                csvReader.close();
                return inputData;
            } else {
                throw new Exception("No data found in csv file");
            }
        } catch (IOException e) {
            Reporter.log("IO errors Found : " + e.getMessage() + " |");

        } catch (CsvException e) {
            Reporter.log("CSV errors Found : " + e.getMessage() + " |");
        } catch (Exception e) {
            System.out.println("Error occured : " + e.getMessage());
            Reporter.log("CSV errors Found : " + e.getMessage() + " |");
        }

        return new Object[0][0];
    }

    @Test(dataProvider = "Event_Details")
    public void testForm(String name, String email, String date, String addDetails) {

        WebElement fullName = webDriver.findElement(By.id("full-name"));
        WebElement emailField = webDriver.findElement(By.id("email"));
        WebElement dateField = webDriver.findElement(By.xpath("//input[@name='event-date']"));
        WebElement additionalField = webDriver.findElement(By.id("additional-details"));
        WebElement submitButton = webDriver.findElement(By.xpath("//button[text()='Submit']"));

        fullName.sendKeys(name);
        emailField.sendKeys(email);
        dateField.sendKeys(date);
        additionalField.sendKeys(addDetails);
        submitButton.click();

        By confirmationId = By.id("action-confirmation");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(confirmationId));
        WebElement result = webDriver.findElement(confirmationId);
        assertEquals(result.getText(), "Your event has been scheduled!");

        webDriver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        webDriver.close();
    }
}
