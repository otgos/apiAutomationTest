package http_get_method_request;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends HerOkuAppBaseUrl {

    /*
            Given
                https://restful-booker.herokuapp.com/booking
            When
                User send a request to the URL
            Then
                Status code is 200
            And
               Among the data there should be someone whose firstname is "Jim" and last name is "Jackson"
 */
    @Test
    public void get04(){
        specification.pathParam("first", "booking").queryParams("firstname", "Joe","lastname");
        Response response = given().spec(specification).when().get("/{first}");

        response.prettyPrint();
    }
}
