import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class test001 {

    @Test
    public void getPokemons() {

        RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "");

        System.out.println("Status: " + response.getStatusLine());

        System.out.println("Response: " + response.prettyPrint());

    }

}
