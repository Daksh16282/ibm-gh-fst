package restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddPet {
    // Set Base URL
    String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void AddNewPet() {
        // Write the request body in one line
        String reqBody = "{\"id\": 16282, \"name\": \"Bhuru\", \"status\": \"alive\"}";

        Response response = given().contentType(ContentType.JSON) // Set headers
                .body(reqBody).when().post(ROOT_URI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        
        response.then().body("status", equalTo("alive"));

    }
}
