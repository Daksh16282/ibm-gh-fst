package restActivities;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitProject {
    RequestSpecification request;
    final static String ssh_Key = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIMAHIeeB9QCNWUs12BUTSzpVufTHmdUX80gCbmraGwGC";
    static int ssh_id;

    private void setId(int id) {
        ssh_id = id;
    }

    @BeforeClass
    public void setUp() {
        // Set Auth Header
        request = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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 ")
                .setBaseUri("https://api.github.com").build();
    }

    @Test(priority = 1)
    public void postReq() {
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("title", "MyRestKey");
        requestBody.put("key", ssh_Key);

        Response response = given().spec(request).when()
                .body(requestBody)
                .post("/user/keys");

        int responseId = response.body().path("id");
        setId(responseId);
        response.then().statusCode(201);
    }

    @Test(priority = 2)
    public void getReq() {
        Response response = given().spec(request).when()
                .pathParam("keyId", ssh_id)
                .get("/user/keys/{keyId}");
        System.out.println("Response from get is : " + response.body().prettyPrint());
        response.then().statusCode(200);
    }

    @Test(priority = 3)
    public void deleteReq() {
        Response response = given().spec(request).when()
                .pathParam("keyId", ssh_id)
                .delete("/user/keys/{keyId}");
        System.out.println("Response from delete is : " + response.body().prettyPrint());
        response.then().statusCode(204);
    }
}
