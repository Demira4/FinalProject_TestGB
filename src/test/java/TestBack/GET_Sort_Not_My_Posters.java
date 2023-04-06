package TestBack;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GET_Sort_Not_My_Posters extends AbstractTest {
    @Test
    @Order(1)
    void DESC_NotMyPosts(){
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "DESC")
                .formParam("page", 1)
                .when()
                .get(getBaseUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(200);

    }
    @Test
    @Order(2)
    void DESC_NotMyPostsWithoutAuth() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .header("X-Auth-Token", "")
                .formParam("order", "DESC")
                .formParam("page", 1)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(401);
    }
    @Test
    @Order(3)
    void DESC_NotMyPosts_negative() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "DESC")
                .formParam("page", -1)
                .when()
                .get(getBaseUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(400);

    }
    @Test
    @Order(4)
    void ASC_NotMyPosts(){
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "ASC")
                .formParam("page", 1)
                .when()
                .get(getBaseUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(200);

    }
    @Test
    @Order(5)
    void ASC_NotMyPostsWithoutAuth() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .header("X-Auth-Token", "")
                .formParam("order", "ASC")
                .formParam("page", 1)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(401);
    }
    @Test
    @Order(6)
    void ASC_NotMyPosts_negative() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "ASC")
                .formParam("page", -1)
                .when()
                .get(getBaseUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(400);

    }

    @Test
    @Order(7)
    void ALL_NotMyPosts(){
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "ALL")
                .formParam("page", 1)
                .when()
                .get(getBaseUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(200);

    }
    @Test
    @Order(8)
    void ALL_NotMyPostsWithoutAuth() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .header("X-Auth-Token", "")
                .formParam("order", "ALL")
                .formParam("page", 1)
                .when()
                .get(getBaseUrl() + "api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(401);
    }
    @Test
    @Order(9)
    void ALL_NotMyPosts_negative() {
        given()
                .spec(getRequestSpecificationGetNotMy())
                .formParam("order", "ALL")
                .formParam("page", -1)
                .when()
                .get(getBaseUrl()+"api/posts")
                .then()
                .spec(getResponseSpecificationGetNotMy())
                .statusCode(400);

    }


}
