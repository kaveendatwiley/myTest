import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDelete {
    @Test

    public void Trydelete(){


        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }

}
