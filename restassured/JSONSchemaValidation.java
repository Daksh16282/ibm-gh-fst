package restAssured;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;;

public class JSONSchemaValidation {
    // Set Base URL
    String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void getPetInfo() throws MalformedURLException {
        // Generate response
        Response response = given().contentType(ContentType.JSON) // Set headers
                .when().get(ROOT_URI + "/77232"); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());

        // Validate JSON Schema from URL
        URL swaggerSchema = URI.create("https://petstore.swagger.io/v2/swagger.json").toURL();
        response.then().body(matchesJsonSchema(swaggerSchema));
    }
}
