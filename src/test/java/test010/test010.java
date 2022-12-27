package test010;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class test010 {
    @Test
    public void jsonArray() {


        RestAssured.baseURI = "https://bookstore.demoqa.com/BookStore/v1/Books";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        Book[] books = response.jsonPath().getObject("books", Book[].class);

        for (Book book: books){
            System.out.println("Book title: " + book.title + ", author: " + book.author);
        }

    }

}
