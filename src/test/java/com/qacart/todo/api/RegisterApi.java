package com.qacart.todo.api;

import com.qacart.todo.Utils.UserUtils;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.List;
import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    public String getFirstName(){
        return this.firstName;
    }
    public String getToken(){
        return this.accessToken;
    }
    public String getUserId() {
        return this.userId;
    }
    public List<Cookie> getCookies(){
        return this.restAssuredCookies;
    }
    public void register(){
        User user = UserUtils.generaterandomUser();
        Response response =
                given()
                    .baseUri("https://todo.qacart.com/")
                    .header("Content-Type","application/json")
                    .body(user)
                .when()
                    .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                    .extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong with the request!");
        }

         restAssuredCookies = response.detailedCookies().asList();
         accessToken = response.path("access_token");
         userId = response.path("userID");
         firstName = response.path("firstName");

    }

}
