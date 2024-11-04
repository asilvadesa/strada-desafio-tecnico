package com.strada.api.testcase;

import com.strada.api.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@SpringBootTest
public class FunctionalTest extends BaseTest {

    @Test
    void getPostsWithSucess(){
        given()
            .spec(requestSpecification)
        .expect()
            .statusCode(200)
            .body("id.size()", Matchers.is(100))
            .body(matchesJsonSchemaInClasspath("schemas/posts-schema.json"))
        .when()
            .get("posts");
    }
}
