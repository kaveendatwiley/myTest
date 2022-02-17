import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPut {
    @Test
    public void Tryput(){
        JSONObject requesting = new JSONObject();

        requesting.put("name","Raghav");
        requesting.put("job","Teacher");

        System.out.println(requesting.toJSONString());

        given()

                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();










    }
}
