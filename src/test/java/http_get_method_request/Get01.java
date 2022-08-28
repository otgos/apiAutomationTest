package http_get_method_request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
       Given https://restful-booker.herokuapp.com/booking/ endpoint
       When user sends a GET request to the url
       Then HTTP status code should be 200
       And   content type should be Json
       And status line should be HTTP/1.1 200 OK
*/
public class Get01 {
    @Test
    public void get01(){

        //this is primitive way and we do not use it
        String endpoint = "https://restful-booker.herokuapp.com/booking/4";
        Response response= given().when().get(endpoint);
        //response.then().assertThat().statusCode(201);
        //response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }
}
