package com.qacart.todo.api;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddTaskApi {

    public void addTask(String accessToken){
        Task task = new Task(false,"learn");
       Response response = given()
               .baseUri(ConfigUtils.getInstance().getBaseUrl())
               .header("content-type","application/json")
               .body(task)
               .auth().oauth2(accessToken)
       .when()
               .post(EndPoint.API_ADDTASK_ENDPOINT)
       .then()
               .log().all().extract().response();

        if (response.statusCode() != 201){
            throw new RuntimeException("Something went wrong with the request!");
        }
    }

}
