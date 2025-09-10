package com.aw.tutorial;

/**
 * Minimal HelloWorld Example
 * 
 * This demonstrates the most basic Java program structure
 * and how it relates to automation testing
 */
public class HelloWorld {

    /**
     * Main method - entry point of the Java application
     * This is where the JVM starts executing our program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Print a simple message
        System.out.println("Hello, World!");
        
        // Print Java version information
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Java Home: " + System.getProperty("java.home"));
        
        // Print operating system information
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        
        // Demonstrate how this relates to automation
        demonstrateAutomationConnection();
    }

    /**
     * Shows how basic Java concepts connect to automation
     */
    public static void demonstrateAutomationConnection() {
        System.out.println("\n=== AUTOMATION CONNECTION ===");
        
        // 1. System properties are used by Selenium WebDriver
        System.out.println("1. System Properties (used by WebDriver):");
        System.out.println("   - java.version: " + System.getProperty("java.version"));
        System.out.println("   - os.name: " + System.getProperty("os.name"));
        
        // 2. Class loading (how dependencies work)
        System.out.println("\n2. Class Loading (how Maven dependencies work):");
        Class<?> currentClass = HelloWorld.class;
        System.out.println("   - Current class: " + currentClass.getName());
        System.out.println("   - Class loader: " + currentClass.getClassLoader());
        
        // 3. Memory management (important for WebDriver instances)
        System.out.println("\n3. Memory Management (important for WebDriver):");
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("   - Total Memory: " + (totalMemory / 1024 / 1024) + " MB");
        System.out.println("   - Free Memory: " + (freeMemory / 1024 / 1024) + " MB");
        System.out.println("   - Used Memory: " + (usedMemory / 1024 / 1024) + " MB");
    }
}

