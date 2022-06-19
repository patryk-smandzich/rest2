import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test002 {

    @Test
    public void getDitto() {

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("pokemon/ditto");

        int stuatusCode = response.getStatusCode();

        Assert.assertEquals(stuatusCode, 200);

    }

    @Test
    public void getNoPoke() {

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("pokemon/xyz");

        int stuatusCode = response.getStatusCode();

        System.out.println(stuatusCode);

        Assert.assertEquals(stuatusCode, 404);

    }

}
