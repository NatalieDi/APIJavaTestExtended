package extended.controllers;

import extended.models.User;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserController {
    RequestSpecification requestSpecification = given();
    private static final String BASE_URL = "https://petstore.swagger.io/v2/";

    public UserController() {
        RestAssured.defaultParser = Parser.JSON;
        this.requestSpecification.contentType(ContentType.JSON);
        this.requestSpecification.accept(ContentType.JSON);
        this.requestSpecification.baseUri(BASE_URL);
        this.requestSpecification.filters(new AllureRestAssured());
    }

    @Step("Create user")
    public Response createUser(User user) {
        this.requestSpecification.body(user);
        return given(this.requestSpecification).post("user").andReturn();
    }
}
