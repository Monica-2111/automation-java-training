package com.aw.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Sample Rest Assured test to demonstrate API testing
 * Calls https://reqres.in/api/users?page=2 and asserts page=2
 */
public class ReqResApiTest {

    @BeforeClass
    public void setUp() {
        // Set base URI for the API
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testGetUsersPage2() {
        // Make GET request to /api/users with page=2 parameter
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/api/users")
                .then()
                .extract().response();

        // Assert status code is 200
        Assert.assertEquals(response.getStatusCode(), 200, 
            "Status code should be 200");

        // Assert that the page number in response is 2
        int pageNumber = response.jsonPath().getInt("page");
        Assert.assertEquals(pageNumber, 2, 
            "Page number should be 2");

        // Assert that we have users data
        int totalUsers = response.jsonPath().getInt("data.size()");
        Assert.assertTrue(totalUsers > 0, 
            "Should have users data");

        // Print response details for verification
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Page Number: " + pageNumber);
        System.out.println("Total Users: " + totalUsers);
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Test
    public void testGetUsersPage2WithJsonPath() {
        // Alternative approach using JSON path assertions
        given()
                .queryParam("page", 2)
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("page", org.hamcrest.Matchers.equalTo(2))
                .body("data", org.hamcrest.Matchers.notNullValue())
                .body("data.size()", org.hamcrest.Matchers.greaterThan(0));
    }
}
