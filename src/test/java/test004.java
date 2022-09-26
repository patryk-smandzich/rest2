import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test004 {

    @Test
    public void checkWeight() {

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("pokemon/ditto");

        JsonPath json = response.jsonPath();

        try {
            Assert.assertEquals(json.get("weight").toString(), "40");
        } catch (AssertionError e) {
            System.out.println("Wrong weight!");
            throw e;
        }
        System.out.println("Right weight!");
    }

}
