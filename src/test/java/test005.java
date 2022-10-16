import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test005 {

    @Test
    public void checkQuery() {

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.queryParams("limit", "20").queryParam("offset", "20").get("/ability");

        String count = com.jayway.jsonpath.JsonPath.read(response.asString(), "$..results.length()").toString().replace("[", "").replace("]", "");

        Assert.assertEquals(count, "20");
    }

}
