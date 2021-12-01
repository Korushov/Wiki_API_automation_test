
import RequestBody.LoginRequestBody;
import ResponseBody.LoginResponseBody;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import org.testng.annotations.Test;


import javax.servlet.http.HttpSession;

import static io.restassured.RestAssured.given;

public class LoginTest {

    private Cookies cookies;
    CookieFilter cookieFilter = new CookieFilter();
    SessionFilter sessionFilter = new SessionFilter();

    public String getToken() {
        RestAssured.baseURI = "https://test.wikipedia.org";
        Response response = given()
//                .sessionId("1234")
                .filter(sessionFilter)
                .param("action", "query")
                .param("meta", "tokens")
                .param("format", "json")
                .param("type", "login").
                        when().get("/w/api.php")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        cookies = response.getDetailedCookies();
        response.prettyPrint();
        return response.path("query.tokens.logintoken");
    }

    @Test
    public void SuccessLogin(){
        RestAssured.baseURI = "https://test.wikipedia.org";
        LoginRequestBody requestBody =  new LoginRequestBody("secret", "user", getToken() + "\\");
//        HttpSession session = request.getSession();
        Response response = given()
                .filter(sessionFilter)
//                .sessionId("1234")
                .header("Content-type", "application/json")
//                .filter(cookieFilter)
//                .cookies(cookies)
//                .and()
                .body(requestBody)
                .when()
                .post("/w/api.php?action=login&format=json")
                .then()
                .extract().response();

        response.getBody().prettyPrint();
    }


    @Test
    public void Login() {

    }



//    @Test
//    public void loginWithoutDomain() {
//        RequestSpecification request = new RestAssured().given().contentType(ContentType.JSON);
//        JSONObject requestBody = new JSONObject();
//        requestBody.put("lgname", "user");
//        requestBody.put("lgpassword", "secret");
//        requestBody.put("logintoken", loginToken);
//        request.headers("Accept", "application/json")
//                .body(requestBody.toString());
//        Response response = request.post("/w/api.php");
//        response.prettyPrint();
//    }


//    @RunWith(Parameterized.class)
//    public class InvalidParametersLogin {
//        @Parameters
//        public Collection<Object[]> data() {
//            return Arrays.asList(new Object[][] {
//                {"", "", "error"},{"user", "", "error"}, {"", "secret", "error"}
//            });
//            }
//
//            private String lgname;
//            private String lgpassword;
//            private String expectedError;
//
//        public InvalidParametersLogin(String lgname, String lgpassword, String expectedError) {
//            this.lgname = lgname;
//            this.lgpassword = lgpassword;
//            this.expectedError = expectedError;
//        }
//    }
//
//    @Test
//    public void LoginWithoutRequiredFields() {
//
//    }


}
