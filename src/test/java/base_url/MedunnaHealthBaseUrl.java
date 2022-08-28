package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MedunnaHealthBaseUrl {

    protected RequestSpecification spec ;
    @Before
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
    }

    public  String generateToken(){
        //Set the base url and path params
        spec.pathParams("first", "api", "second", "authenticate");
        //Set the data
        Map<String, Object> data  = new HashMap();
        data.put("username", "admin79");
        data.put("password", "admin");
        data.put("rememberMe", true);
        //Send the request and get the response
        Response response = given().spec(spec).body(data).contentType(ContentType.JSON).
                when().post("/{first}/{second}");
        JsonPath json = response.jsonPath();
        return json.getString("id_token");
    }

}
