import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test003 {

    @Test
    public void getPokeHeaders(){

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        Headers allHeaders = response.getHeaders();

        for(Header header: allHeaders) {
            System.out.println("Header name: " + header.getName() + ", value: " + header.getValue());
        }

    }

    @Test
    public void getPokeHeader(){

        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        String headerContentEncoding = response.getHeader("Content-Encoding");
        System.out.println(headerContentEncoding);

        Assert.assertEquals(headerContentEncoding, "gzip");

    }


}
