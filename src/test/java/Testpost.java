import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Testpost {

    @Test
    public void testingPost(){

        JSONObject  request = new JSONObject();

        request.put("name","Raghav");
        request.put("job", "Teacher");
        System.out.println(request.toJSONString());


        given().
                header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users?page=2").
                        then().statusCode(201)
                .log().all();


    }


}
