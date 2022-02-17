import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LocalApiTesting {

    //@Test
    public void TestWithLocalApi(){
        baseURI="http://localhost:3000/";
        given()
                .get("Users")
                .then().statusCode(200)
                .log().all();
        given().get("subjects")
                .then().statusCode(200)
                .log().all();


    }

        @Test
    public void PostWithLocalApi(){
        JSONObject request = new JSONObject();
        request.put("firstName","Akonim");
        request.put("lastName","Miraj");
        request.put("id",4);
        request.put("subjectId",6);


            request.put("firstName","buii");
            request.put("lastName","ytur");
            request.put("id",5);
            request.put("subjectId",7);


        baseURI = "http://localhost:3000/";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(500)
                .log().all();

    }

}
