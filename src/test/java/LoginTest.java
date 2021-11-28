
import RequestBody.LoginResponseBody;
import RequestBody.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    @Test
    public void get() {
        RestAssured.baseURI = "https://test.wikipedia.org";
        RequestBody requestBody = new RequestBody("secret", "user", LoginResponseBody.getToken(), "json");

        Response response = given().header("Content-Type", "application/json")
                .body(requestBody).
        when().post("/w/api.php").
        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        response.prettyPrint();





    }


}
