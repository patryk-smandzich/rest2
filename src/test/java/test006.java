import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test006 {

    @Test
    public void postRequest() {

        RestAssured.baseURI = "https://reqres.in/";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "PatrickQ2");
        requestParams.put("job", "Tester");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.post("/api/users");
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

}
