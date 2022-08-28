package http_get_method_request;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.ToDo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
  /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
     */


public class Get07 extends JsonPlaceHolderBaseUrl {
    @Test
    public void get07(){
        spec.pathParams("first", "todos", "second", 2);
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("userId", 1);
        expectedDataMap.put("id", 2);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("completed", false);

        //2nd of setting data
        ToDo expectedToDoData = new ToDo(1, 2, "quis ut nam facilis et officia qui", false);

        //send request get the and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //vaidate

        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("Expected DATA:    : "+expectedDataMap);
        System.out.println("Actual DATA:     : "+actualDataMap);


        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("id"), actualDataMap.get("id"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));


        //validate 2nd way
        ToDo actualToDoData = response.as(ToDo.class);
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(expectedToDoData.getId(), actualToDoData.getId());
        softAssert.assertEquals(expectedToDoData.getUserId(), actualToDoData.getUserId());
        softAssert.assertEquals(expectedToDoData.getTitle(), actualToDoData.getTitle());
        softAssert.assertEquals(expectedToDoData.isCompleted(), actualToDoData.isCompleted());
        softAssert.assertAll();

        System.out.println("This is EXPECTED TODO OBJECT DATA: "+expectedToDoData);

        System.out.println("This is ACTUAL TODO OBJECT DATA: "+actualToDoData);
    }
}
