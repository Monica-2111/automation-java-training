package com.aw.tutorial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Selenium Example - How JDK/JRE/JVM Matter for WebDriver
 * 
 * This test demonstrates how Java concepts apply to Selenium automation
 */
public class SeleniumJvmExample {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("=== SELENIUM JVM EXAMPLE ===");
        
        // Show JVM information before creating WebDriver
        showJvmInfo();
        
        // Setup WebDriver using WebDriverManager
        // This demonstrates how Maven dependencies work with JVM
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        System.out.println("WebDriver instance created successfully");
    }

    @Test
    public void testWebDriverWithJvmInfo() {
        System.out.println("\n--- Test Execution ---");
        
        // Navigate to a page
        driver.get("https://example.org");
        
        // Get page title
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        
        // Show memory usage during test execution
        showMemoryUsage();
        
        // Assert title
        assert title.equals("Example Domain") : "Title should be 'Example Domain'";
        System.out.println("Test passed successfully!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver instance closed");
        }
        
        // Show memory usage after cleanup
        showMemoryUsage();
    }

    /**
     * Shows JVM information relevant to Selenium
     */
    private void showJvmInfo() {
        System.out.println("\n🔍 JVM Information for Selenium:");
        System.out.println("   - Java Version: " + System.getProperty("java.version"));
        System.out.println("   - JVM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("   - JVM Name: " + System.getProperty("java.vm.name"));
        System.out.println("   - OS Name: " + System.getProperty("os.name"));
        System.out.println("   - OS Architecture: " + System.getProperty("os.arch"));
        
        // Show available processors (important for parallel test execution)
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("   - Available Processors: " + processors);
    }

    /**
     * Shows memory usage - important for WebDriver instances
     */
    private void showMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory();
        
        System.out.println("\n💾 Memory Usage:");
        System.out.println("   - Total Memory: " + (totalMemory / 1024 / 1024) + " MB");
        System.out.println("   - Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
        System.out.println("   - Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        System.out.println("   - Max Memory: " + (maxMemory / 1024 / 1024) + " MB");
        
        // Suggest garbage collection if memory usage is high
        if (usedMemory > maxMemory * 0.8) {
            System.out.println("   ⚠️ High memory usage detected!");
            System.gc(); // Suggest garbage collection
        }
    }
}

