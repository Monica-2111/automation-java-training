package com.aw.tutorial;

/**
 * Java Basics Tutorial - Understanding JDK, JRE, JVM and Project Structure
 * 
 * This class demonstrates fundamental Java concepts and how they apply to automation projects
 */
public class JavaBasicsTutorial {

    public static void main(String[] args) {
        System.out.println("=== Java Basics Tutorial for Automation ===");
        
        // Demonstrate basic Java concepts
        demonstrateJavaBasics();
        
        // Show how these concepts apply to automation
        demonstrateAutomationRelevance();
    }

    /**
     * Demonstrates basic Java programming concepts
     */
    public static void demonstrateJavaBasics() {
        System.out.println("\n1. BASIC JAVA CONCEPTS:");
        
        // Variables and Data Types
        String projectName = "Automation Training";
        int javaVersion = 17;
        boolean isAutomationProject = true;
        double seleniumVersion = 4.21;
        
        System.out.println("Project: " + projectName);
        System.out.println("Java Version: " + javaVersion);
        System.out.println("Is Automation Project: " + isAutomationProject);
        System.out.println("Selenium Version: " + seleniumVersion);
        
        // Method calls
        String greeting = createGreeting("Automation Engineer");
        System.out.println(greeting);
        
        // Array example
        String[] automationTools = {"Selenium", "Rest Assured", "TestNG", "WebDriverManager"};
        System.out.println("Automation Tools:");
        for (String tool : automationTools) {
            System.out.println("- " + tool);
        }
    }

    /**
     * Shows how Java concepts apply to automation projects
     */
    public static void demonstrateAutomationRelevance() {
        System.out.println("\n2. AUTOMATION PROJECT RELEVANCE:");
        
        // Class instantiation (like creating WebDriver instances)
        System.out.println("Creating automation components...");
        
        // Method calls (like calling Selenium methods)
        String browserInfo = getBrowserInfo("Chrome");
        System.out.println("Browser: " + browserInfo);
        
        // Exception handling (crucial for automation)
        try {
            simulateWebDriverOperation();
        } catch (Exception e) {
            System.out.println("Handled exception: " + e.getMessage());
        }
    }

    /**
     * Creates a greeting message
     * @param role the role of the person
     * @return greeting message
     */
    public static String createGreeting(String role) {
        return "Hello, " + role + "! Welcome to Java automation!";
    }

    /**
     * Gets browser information
     * @param browserName name of the browser
     * @return browser information
     */
    public static String getBrowserInfo(String browserName) {
        return browserName + " WebDriver ready for automation";
    }

    /**
     * Simulates a WebDriver operation that might throw an exception
     */
    public static void simulateWebDriverOperation() throws Exception {
        // Simulate a potential failure scenario
        boolean operationSuccessful = Math.random() > 0.5;
        if (!operationSuccessful) {
            throw new Exception("WebDriver operation failed - element not found");
        }
        System.out.println("WebDriver operation completed successfully");
    }
}

