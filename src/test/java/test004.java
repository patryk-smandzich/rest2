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

    @Test
    public void dittoNoDamageFrom() {

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("pokemon/ditto");

        String name = getJsonValue(com.jayway.jsonpath.JsonPath.read(response.asString(), "$..type.name").toString());
        String url = getJsonValue(com.jayway.jsonpath.JsonPath.read(response.asString(), "$..type.url").toString());

        Response response2 = httpRequest.get(url);

        String no_damage_from = getJsonValue(com.jayway.jsonpath.JsonPath.read(response2.asString(), "$..no_damage_from..name").toString());

        System.out.println("Ditto is a " + name + " type pokemon and does not get damage from " + no_damage_from + " type pokemon!");
    }

    public String getJsonValue(String value) {
        return value.replace("[\"", "").replace("\"]", "").replaceAll("\\\\", "");
    }

}
