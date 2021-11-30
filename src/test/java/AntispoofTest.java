import Data.DataProviders;
import Entities.RandomName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AntispoofTest {

    @Test(dataProvider = "validNameData", dataProviderClass = DataProviders.class)
    public void validUsername(String username) {
        RestAssured.baseURI = "https://test.wikipedia.org";

                given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", username).
        when()
                .get("/w/api.php").
        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("antispoof.result", equalTo("pass"))
                .extract()
                .response();
    }

    @Test
    public void emptyUsername() {
        RestAssured.baseURI = "https://test.wikipedia.org";

                given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", "").
                        when()
                .get("/w/api.php").
                        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("antispoof.result", equalTo("error"))
                .body("antispoof.error", equalTo("Empty string"))
                .extract().response();
    }



    @Test
    public void MaxLengthUsername() {
        RestAssured.baseURI = "https://test.wikipedia.org";

                given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", RandomName.getRandomName()).
                        when()
                .get("/w/api.php").
                        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("antispoof.result", equalTo("pass"))
                .extract()
                .response();
    }


    @Test(dataProvider = "withoutLettersData", dataProviderClass = DataProviders.class)
    public void nameWithoutLetters(String username) {
        RestAssured.baseURI = "https://test.wikipedia.org";

                given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", username).
                        when()
                .get("/w/api.php").
                        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("antispoof.result", equalTo("error"))
                .body("antispoof.error", equalTo("Does not contain any letters"))
                .extract()
                .response();
    }

    @Test(dataProvider = "withNumberData", dataProviderClass = DataProviders.class)
    public void nameWithNumber(String username) {
        RestAssured.baseURI = "https://test.wikipedia.org";

                given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", username).
                        when()
                .get("/w/api.php").
                        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(not(hasKey("error")))
                .extract()
                .response();
    }

    @Test(dataProvider = "twoAlphabetNameData", dataProviderClass = DataProviders.class)
    public void UsernameFromTwoAlphabets(String username) {
        RestAssured.baseURI = "https://test.wikipedia.org";

                given()
                .param("action", "antispoof")
                .param("format", "json")
                .param("username", username).
                        when()
                .get("/w/api.php").
                        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("antispoof.result", equalTo("error"))
                .body("antispoof.error", equalTo("Contains incompatible mixed scripts"))
                .extract()
                .response();
    }
}
