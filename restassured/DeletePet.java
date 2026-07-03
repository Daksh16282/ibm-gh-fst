package restAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeletePet {
    // Set Base URL
    String ROOT_URI = "https://petstore.swagger.io/v2/pet/{petId}";

    @Test
    public void deletePet() {
        Response response = given().contentType(ContentType.JSON) // Set headers
                .when().pathParam("petId", 16282).delete(ROOT_URI); // Send DELETE request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        response.then().statusCode(200);

    }
}
