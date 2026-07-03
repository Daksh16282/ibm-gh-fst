package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

public class ReadFromJSON {
    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void addNewPet() throws IOException {
        // Import JSON file
        File file = new File("src/test/resources/input.json");
        Response response = given()
                .contentType(ContentType.JSON) // Set headers
                .body(file) // Pass request body from file
                .when().post(ROOT_URI); // Send POST request

        // Print response
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        // Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
    }
}
