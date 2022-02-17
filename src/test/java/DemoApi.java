import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoApi {
    @Test
    void test1(){
                Response output = get("https://reqres.in/api/users?page=2");

                System.out.println("Response :" + output.asString());
                System.out.println("Status Code : "+ output.getStatusCode());
                System.out.println("Status Line : " + output.getStatusLine());
                System.out.println("Body : "+ output.getBody().asString());
                System.out.println("Time Consumed : " + output.getTime());
                System.out.println("This is header : "+ output.getHeader("Content-type"));
                System.out.println("Session ID : " + output.getSessionId());
                System.out.println("Response time : " + output.time());



        }

    @Test
    void test2(){
        given()
                .when()
                .get("https://reqres.in/api/users?page=20")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                 .body("data.id[1]",equalTo(8))
                .body("data.first_name",hasItem("Michael"))
                .log().all();



    }



}
