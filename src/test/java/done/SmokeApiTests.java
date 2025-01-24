package done;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeApiTests {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/";
    @Test
    void createUserApiTest() {
        //given(). - conf
        //when(). - http
        //then(). - assertion
        String bodyJson = """
                {
                  "id": 0,
                  "username": "string",
                  "firstName": "string",
                  "lastName": "string",
                  "email": "string",
                  "password": "string",
                  "phone": "string",
                  "userStatus": 0
                }""";


        ValidatableResponse response = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body(bodyJson)
                .when()
                .post(BASE_URL+"user")
                .then();
        response.statusCode(200);
        response.body("code", Matchers.equalTo(200));
        response.body("type", Matchers.equalTo("unknown"));
        response.body("message", Matchers.notNullValue(String.class));
        Response responseAsResponse = response.extract().response();
        responseAsResponse.prettyPrint();
        Assertions.assertEquals(200, responseAsResponse.statusCode());
    }
}
