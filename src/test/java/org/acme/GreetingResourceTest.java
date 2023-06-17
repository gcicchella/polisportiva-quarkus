package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class GreetingResourceTest {

//    @Test
//    public void testGetUsersEndpoint() {
//        given()
//                .when().get("/db")
//                .then()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("$.size()", equalTo(2));
//    }
}