package restActivities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//Mimic property transfer from SOAPUi on petId
public class ChallengeActivity {

    final static String BASE_URL = "https://petstore.swagger.io/v2/pet";
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    private static long petId;

    private void setPetId(long id) {
        petId = id;
    }

    @BeforeClass
    public void setUp() {
        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL).build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

    @Test(priority = 1)
    public void postPet() {
        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("name", "Husky");
        jsonBody.put("status", "active");
        Response response = given().spec(requestSpecification)
                .when().body(jsonBody).post();
        long id = response.body().path("id");
        setPetId(id);
        response.then().spec(responseSpecification);

    }

    @Test(priority = 2)
    public void putPet() {
        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("id", petId);
        jsonBody.put("name", "Husky");
        jsonBody.put("status", "playing");
        Response response = given().spec(requestSpecification)
                .when().body(jsonBody).put();
        response.then().spec(responseSpecification);

    }

    @Test(priority = 3)
    public void getPet() {
        Response response = given().spec(requestSpecification)
                .when().pathParam("petId", petId).get("/{petId}");
        response.then().spec(responseSpecification);
        response.then().body("status", equalTo("playing"));
    }

    @Test(priority = 4)
    public void deletePet() {
        Response response = given().spec(requestSpecification)
                .when().pathParam("petId", petId).delete("/{petId}");
        response.then().spec(responseSpecification);
    }

    @Test(priority = 5)
    public void getPetAgain() {
        Response response = given().spec(requestSpecification)
                .when().pathParam("petId", petId).get("/{petId}");
        response.then().statusCode(404);
    }

}
