import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class firstTest {

    @Test
    public void getBookDetails() {

        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "");

        System.out.println("Status: " + response.getStatusLine());

        System.out.println("Response: " + response.prettyPrint());

    }

}
