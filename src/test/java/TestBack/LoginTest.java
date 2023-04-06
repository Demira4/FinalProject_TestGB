package TestBack;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LoginTest extends AbstractTest {
    @Test
    void postValid_Username3() {
        given()
                .body("{\n"
                        + " \"username\": lol,\n"
                        + " \"password\":9cdfb439c7,\n"
                        + "}")
                .contentType(ContentType.JSON)

                .when()
                .post(getBaseUrl() + "login")
                .then()
                .statusCode(200)
                .body(containsString("token"))
                .contentType("text/html");
    }
    @Test
    void postValid_Username20()    {
        given()
                .queryParam("username", "wertyujhg123fdsazx23")
                .queryParam("password", "8f15c98096")
                .contentType("application/x-www-form-urlencoded; charset-UTF-8")

                .when()
                .post(getBaseUrl() + "login")
                .then()
                .statusCode(200)
                .body(containsString("token"))
                .contentType("text/html");
    }
    @Test
    void postValid_Username10(){
        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "10simvolov")
                .queryParam("password", "6f91ae8332")
               // .contentType("application/x-www-form-urlencoded; charset-UTF-8")

                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                .body(containsString("token"))
                .statusCode(200);



    }

    @Test
    void postInValid_EmptyUsername() {
// empty username field
        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "")
                .queryParam("password", "6f91ae8332")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);
    }
    @Test
            void postInValid_EmptyPassword(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "lol")
                .queryParam("password", "")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
               // .body(containsString("token"))
                .statusCode(401);

    }
    @Test
    void postInValid_EmptyUsernameAndPassword(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "")
                .queryParam("password", "")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);

    }
    @Test
    void postInValid_Username21(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "jhgfvbnjhf1234gfbch65")
                .queryParam("password", "fe0d1487d8")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);

    }

    @Test
    void postInValid_Username2(){

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "gg")
                .queryParam("password", "73c18c59a3")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);

    }
    @Test
    void postInValid_UsernameWithRusAlphabetSpec() {

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "Свет1 @")
                .queryParam("password", "052451ad17")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);
    }
    @Test
    void postInValid_UsernameWithRusAlphabet() {

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "Светлана")
                .queryParam("password", "14fcb108d3")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);
    }
    @Test
    void postInValid_UsernameWithEngAlphabetAndSpec() {

        given()
                .spec(getRequestSpecificationPost())
                .queryParam("username", "F@ck2")
                .queryParam("password", "e875c1b3ea")
                .when()
                .post(getBaseUrl() + "login")
                .then()
                .spec(getResponseSpecificationPost())
                //.body(containsString("token"))
                .statusCode(401);
    }
}
