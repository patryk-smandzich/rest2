package test007;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test007 {
@Test
    public void deserialization() {

    RestAssured.baseURI = "https://reqres.in/";

    RequestSpecification httpRequest = RestAssured.given();

    JSONObject requestParams = new JSONObject();
    requestParams.put("name", "Patrick");
    requestParams.put("job", "Tester");

    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(requestParams.toJSONString());

    Response response = httpRequest.post("/api/users");
    System.out.println(response.asString());
    ResponseBody body = response.getBody();

    JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);

    Assert.assertEquals("Patrick", responseBody.name);
    Assert.assertEquals("Tester", responseBody.job);

    }
}
