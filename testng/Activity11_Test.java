package TestNG;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Activity11_Test {

    WebDriver webDriver;
    WebDriverWait wait;

    @SuppressWarnings("null")
    @BeforeClass
    public void setUp() {
        webDriver = new FirefoxDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

        webDriver.get("https://training-support.net/webelements/simple-form");
    }

    public static List<List<String>> readExcel(String filePath) {
        // Creating the base list
        List<List<String>> data = new ArrayList<>();
        // Create the workbook object
        Workbook excelFile;
        try {
            excelFile = new XSSFWorkbook(new FileInputStream(filePath));
            // Select the sheet from the workbook
            Sheet sheet1 = excelFile.getSheetAt(0);
            // Iterate through the rows in the sheet
            for (Row rows : sheet1) {
                // To skip the first row
                if (rows.getRowNum() == 0) {
                    continue;
                }
                // Create a temp list to store one row's data
                List<String> rowData = new ArrayList<>();
                // Iterate through the cells in each row
                for (Cell cells : rows) {
                    switch (cells.getCellType()) {
                        case STRING:
                            // To get string values
                            rowData.add(cells.getStringCellValue().trim());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cells)) {
                                // To get dates
                                rowData.add(cells.getLocalDateTimeCellValue()
                                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                            } else {
                                // To get number
                                rowData.add(String.valueOf(cells.getNumericCellValue()));
                            }
                            break;
                        default:
                            // Add a placeholder string for empty cells
                            rowData.add("-");
                    }
                }
                // Add the temp list to the base list
                data.add(rowData);
                // Close the file
                excelFile.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Return the base list to the DataProvider
        return data;

    }

    @DataProvider(name = "Event_Details")
    public Object[][] dataProvider() {
        try {
            List<List<String>> inputData = readExcel("src/test/resources/formDataXL.xlsx");
            // Convert the data into a 2D array dataset
            // This is the dataset that will be passed to the test functions
            Object[][] data = new Object[inputData.size()][];
            for (int i = 0; i < inputData.size(); i++) {
                data[i] = inputData.get(i).toArray();
            }
            // Return the dataset
            return data;
        } catch (Exception e) {
            System.out.println("Error occured : " + e.getMessage());
            Reporter.log("Errors Found : " + e.getMessage() + " |");
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
