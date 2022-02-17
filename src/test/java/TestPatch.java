import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPatch {
    @Test
    public void Trypatch(){

        JSONObject requesting = new JSONObject();

        requesting.put("name","Donz");
        requesting.put("job","Teacher");

        System.out.println(requesting.toJSONString());

        given()

                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void DeletionTest(){

        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);

    }


}

