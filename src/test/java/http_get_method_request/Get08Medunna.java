package http_get_method_request;

import base_url.MedunnaHealthBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class Get08Medunna extends MedunnaHealthBaseUrl {

    @Test
    public void get08(){
        String  token = generateToken();
        //Set the base url and path params
        spec.pathParams("first", "api", "second", "rooms");
        Response response = given().headers(
                "Authorization",
                "Bearer "+ token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON
        ).spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();



    }

}
