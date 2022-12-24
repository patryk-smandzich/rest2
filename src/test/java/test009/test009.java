package test009;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import test007.JSONFailedResponse;
import test007.JSONSuccessResponse;

public class test009 {
    @Test
    public void putAndDelete() {

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

        JSONSuccessResponse01 responseBody = body.as(JSONSuccessResponse01.class);

        System.out.println("ID = " + responseBody.id);

        JSONObject requestParamsUpdate = new JSONObject();
        requestParamsUpdate.put("name", "Patrick");
        requestParamsUpdate.put("job", "Lead Tester :)");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParamsUpdate.toJSONString());
        Response responseUpdate = httpRequest.put("/api/users/" + responseBody.id);
        System.out.println(responseUpdate.asString());
        ResponseBody bodyUpdate = responseUpdate.getBody();

        JSONSuccessResponse02 responseUpdateJson = bodyUpdate.as(JSONSuccessResponse02.class);

        Assert.assertEquals("Lead Tester :)", responseUpdateJson.job);


        Response responseDelete = httpRequest.delete("/api/users/" + responseBody.id);
        Assert.assertEquals(responseDelete.getStatusCode(), 204);
    }
}
