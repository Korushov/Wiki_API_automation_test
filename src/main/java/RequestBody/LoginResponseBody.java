package RequestBody;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginResponseBody {

    private String lgpassword = "secret";


    public static String getToken() {
        RestAssured.baseURI = "https://test.wikipedia.org";

        Response response = given()
                .param("action", "query")
                .param("meta", "tokens")
                .param("format", "json")
                .param("type", "login").
                        when().get("/w/api.php").
                        then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        String token = response.path("query.tokens.logintoken");
        System.out.println(token);
        response.prettyPrint();
        return token;
    }
}
