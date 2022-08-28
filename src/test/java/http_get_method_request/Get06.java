package http_get_method_request;

import base_url.Dummy;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

/*
        Given
             http://dummy.restapiexample.com/api/v1/employee/7
        When
            I send a GET request to the Url
        Then
            HTTP Status Code should be 200
        And
            Response format should be "application/json"
        And
            Herrod Chandler should be the employee name
        And
            "employee_salary":137500 should be expected salary
        And
           "id":7 should be expected id
     */
public class Get06 extends Dummy {
    @Test
    public void get(){
        spec.pathParams("first", "api","second","v1", "third", "employee", "fourth", 7);
        //Send the Get request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{fourth}");
        //validation 1
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("data.employee_name", equalTo("Herrod Chandler"),"data.employee_salary",
                        equalTo(137500)).body("data.id", equalTo(7));
        JsonPath json = response.jsonPath();
        String name = json.getString("data.employee_name");
        int salary = json.getInt("data.employee_salary");
        int id = json.getInt("data.id");
        //When we use hard assertion, execution will stop once it fails
//        assertEquals("Herrod ",name );
//        assertEquals(137,salary );
//        assertEquals(7,id );
        //Soft assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("ibrahim",name );
        softAssert.assertEquals(547634,salary );
        softAssert.assertEquals(8,id );
        softAssert.assertAll();

    }
}
