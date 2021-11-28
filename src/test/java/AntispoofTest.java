import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AntispoofTest {

    @Test
    public void get() {
        RestAssured.baseURI = "https://test.wikipedia.org";

        Response response = given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", "").
        when()
                .get("/w/api.php").
        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        response.prettyPrint();


    }
}
