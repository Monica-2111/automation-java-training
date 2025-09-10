package com.aw.tutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Rest Assured Example - How JDK/JRE/JVM Matter for API Testing
 * 
 * This test demonstrates how Java concepts apply to Rest Assured automation
 */
public class RestAssuredJvmExample {

    @BeforeClass
    public void setUp() {
        System.out.println("=== REST ASSURED JVM EXAMPLE ===");
        
        // Show JVM information before API testing
        showJvmInfo();
        
        // Set base URI for the API
        RestAssured.baseURI = "https://reqres.in";
        
        System.out.println("Rest Assured configured successfully");
    }

    @Test
    public void testApiWithJvmInfo() {
        System.out.println("\n--- API Test Execution ---");
        
        // Show memory usage before API call
        showMemoryUsage("Before API Call");
        
        // Make API request
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/api/users")
                .then()
                .extract().response();

        // Show memory usage after API call
        showMemoryUsage("After API Call");
        
        // Process response
        int statusCode = response.getStatusCode();
        int pageNumber = response.jsonPath().getInt("page");
        int totalUsers = response.jsonPath().getInt("data.size()");
        
        System.out.println("API Response Details:");
        System.out.println("   - Status Code: " + statusCode);
        System.out.println("   - Page Number: " + pageNumber);
        System.out.println("   - Total Users: " + totalUsers);
        
        // Show response size (important for memory management)
        String responseBody = response.getBody().asString();
        int responseSize = responseBody.length();
        System.out.println("   - Response Size: " + responseSize + " characters");
        
        // Assertions
        assert statusCode == 200 : "Status code should be 200";
        assert pageNumber == 2 : "Page number should be 2";
        assert totalUsers > 0 : "Should have users data";
        
        System.out.println("API test passed successfully!");
    }

    @Test
    public void testMultipleApiCalls() {
        System.out.println("\n--- Multiple API Calls Test ---");
        
        // Test multiple API calls to show memory management
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nAPI Call #" + i);
            
            Response response = given()
                    .queryParam("page", i)
                    .when()
                    .get("/api/users")
                    .then()
                    .extract().response();
            
            int statusCode = response.getStatusCode();
            int pageNumber = response.jsonPath().getInt("page");
            
            System.out.println("   - Page: " + pageNumber + ", Status: " + statusCode);
            
            // Show memory usage after each call
            showMemoryUsage("After Call #" + i);
            
            // Small delay to observe memory behavior
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Shows JVM information relevant to Rest Assured
     */
    private void showJvmInfo() {
        System.out.println("\n🔍 JVM Information for Rest Assured:");
        System.out.println("   - Java Version: " + System.getProperty("java.version"));
        System.out.println("   - JVM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("   - Network Timeout: " + System.getProperty("sun.net.client.defaultConnectTimeout"));
        System.out.println("   - HTTP Agent: " + System.getProperty("http.agent"));
        
        // Show available processors (important for parallel API testing)
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("   - Available Processors: " + processors);
    }

    /**
     * Shows memory usage - important for API response handling
     */
    private void showMemoryUsage(String context) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("\n💾 Memory Usage (" + context + "):");
        System.out.println("   - Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
        System.out.println("   - Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        
        // Show garbage collection info
        long totalGcTime = 0;
        try {
            // This is a simplified way to show GC activity
            System.gc(); // Suggest garbage collection
            Thread.sleep(100); // Small delay
            long newFreeMemory = runtime.freeMemory();
            if (newFreeMemory > freeMemory) {
                System.out.println("   - GC freed: " + ((newFreeMemory - freeMemory) / 1024) + " KB");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
