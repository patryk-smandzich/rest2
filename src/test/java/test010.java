import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class test010 {
    @Test
    public void jsonArray(){


        RestAssured.baseURI = "https://bookstore.demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        JsonPath json = response.jsonPath();

        List<String> allBooks = json.getList("books.title");

        for (String book: allBooks){
            System.out.println("Book title: " + book);
        }

    }

}
