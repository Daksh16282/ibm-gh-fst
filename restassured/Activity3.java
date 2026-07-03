package restActivities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {

    final static String BASE_URL = "https://petstore.swagger.io/v2/pet";
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL).build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

    @DataProvider
    public Object[][] petDataProvider() {
        return new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
    }

    @Test(dataProvider = "petDataProvider", priority = 1)
    public void postPet(int id, String petName, String status) {
        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("id", id);
        jsonBody.put("name", petName);
        jsonBody.put("status", status);
        Response response = given().spec(requestSpecification)
                .when().body(jsonBody).post(BASE_URL);
        response.then().spec(responseSpecification);

    }

    @Test(dataProvider = "petDataProvider", priority = 2)
    public void getPet(int id, String petName, String status) {
        Response response = given().spec(requestSpecification)
                .when().pathParam("petId", id).get("/{petId}");
        response.then().spec(responseSpecification);
    }

    @Test(dataProvider = "petDataProvider", priority = 3)
    public void deletePet(int id, String petName, String status) {
        Response response = given().spec(requestSpecification)
                .when().pathParam("petId", id).delete("/{petId}");
        response.then().spec(responseSpecification);
    }

}
