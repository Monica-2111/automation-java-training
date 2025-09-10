# Java Basics Tutorial for Automation Projects

## Table of Contents
1. [JDK, JRE, JVM Explained](#jdk-jre-jvm-explained)
2. [Project Structure](#project-structure)
3. [HelloWorld Example](#helloworld-example)
4. [How These Concepts Apply to Automation](#how-these-concepts-apply-to-automation)
5. [Running the Examples](#running-the-examples)

## JDK, JRE, JVM Explained

### 📦 JDK (Java Development Kit)
- **What it is**: Complete development environment for Java
- **Contains**: JRE + Development tools (javac, jar, javadoc, debugger)
- **Used for**: Writing, compiling, and debugging Java code
- **In automation**: Needed to compile Selenium and Rest Assured test code

### 🏃 JRE (Java Runtime Environment)
- **What it is**: Runtime environment to execute Java programs
- **Contains**: JVM + Java libraries + Other runtime components
- **Used for**: Running compiled Java applications
- **In automation**: Needed to execute your test scripts

### ⚙️ JVM (Java Virtual Machine)
- **What it is**: Virtual machine that executes Java bytecode
- **Platform-specific**: Different versions for Windows, Linux, macOS
- **Responsibilities**: Memory management, garbage collection, class loading
- **In automation**: Manages WebDriver instances and API connections

### Relationship Diagram
```
┌─────────────────────────────────────┐
│              JDK                    │
│  ┌─────────────────────────────────┐│
│  │              JRE                ││
│  │  ┌─────────────────────────────┐││
│  │  │            JVM              │││
│  │  │  - Bytecode execution       │││
│  │  │  - Memory management        │││
│  │  │  - Garbage collection       │││
│  │  └─────────────────────────────┘││
│  │  - Java libraries              ││
│  │  - Runtime components          ││
│  └─────────────────────────────────┘│
│  - Compiler (javac)               │
│  - Debugger                       │
│  - Documentation tools            │
└─────────────────────────────────────┘
```

## Project Structure

### Maven Standard Directory Layout
```
automation-java-training/
├── pom.xml                          # Maven configuration
├── testng.xml                       # TestNG test suite
├── .gitignore                       # Git ignore rules
└── src/
    ├── main/                        # Production code
    │   ├── java/                    # Java source files
    │   │   └── com/aw/              # Package structure
    │   │       ├── tutorial/        # Tutorial classes
    │   │       └── utils/           # Utility classes
    │   └── resources/               # Configuration files
    │       └── config.properties    # Application properties
    └── test/                        # Test code
        └── java/                    # Test source files
            └── com/aw/              # Test package structure
                ├── selenium/        # Selenium tests
                ├── restassured/     # Rest Assured tests
                └── tutorial/        # Tutorial tests
```

### Why This Structure Matters
1. **Maven Convention**: Maven automatically finds and compiles code
2. **Classpath Management**: Dependencies are loaded correctly
3. **Test Discovery**: TestNG can find test classes automatically
4. **IDE Support**: Better code completion and navigation
5. **Separation of Concerns**: Production code vs test code

## HelloWorld Example

### Basic HelloWorld
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### What Happens When You Run It
1. **Compilation**: `javac HelloWorld.java` → Creates `HelloWorld.class` (bytecode)
2. **Execution**: `java HelloWorld` → JVM loads and executes bytecode
3. **Output**: "Hello, World!" printed to console

### Key Concepts Demonstrated
- **Class**: `HelloWorld` is a class definition
- **Method**: `main` is the entry point method
- **Static**: Method belongs to class, not instance
- **Void**: Method doesn't return a value
- **String[] args**: Command line arguments
- **System.out.println**: Print to console

## How These Concepts Apply to Automation

### For Selenium WebDriver

#### JDK Role
- **Compilation**: Compiles test code with Selenium dependencies
- **Development Tools**: IDE uses JDK for code completion and debugging
- **Maven Integration**: Maven uses JDK to compile and package tests

#### JRE Role
- **Runtime Execution**: Runs compiled test code
- **Library Loading**: Loads Selenium JAR files
- **System Integration**: Manages browser driver processes

#### JVM Role
- **WebDriver Instances**: Manages ChromeDriver, FirefoxDriver objects in memory
- **Memory Management**: Handles large page objects and test data
- **Garbage Collection**: Cleans up closed WebDriver instances
- **Thread Management**: Handles parallel test execution

### For Rest Assured API Testing

#### JDK Role
- **HTTP Client Compilation**: Compiles HTTP request/response code
- **JSON Processing**: Compiles Jackson databind for JSON parsing
- **Dependency Management**: Maven resolves and compiles dependencies

#### JRE Role
- **API Execution**: Runs HTTP client code
- **Network Operations**: Manages HTTP connections
- **Response Processing**: Handles JSON/XML parsing

#### JVM Role
- **Connection Pooling**: Manages HTTP connection objects
- **Memory for Responses**: Stores large API response data
- **Garbage Collection**: Cleans up response objects
- **Thread Safety**: Handles concurrent API calls

### Memory Management in Automation

#### WebDriver Memory Considerations
```java
// Good practice - proper cleanup
@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();  // Releases browser process
        driver = null;  // Helps garbage collection
    }
}
```

#### API Testing Memory Considerations
```java
// Good practice - process large responses efficiently
Response response = given().when().get("/api/large-data");
String responseBody = response.getBody().asString();
// Process response immediately, don't store unnecessarily
```

## Running the Examples

### Prerequisites
- Java 17 JDK installed
- Maven installed
- Chrome browser (for Selenium tests)

### Compile and Run Tutorial Classes
```bash
# Compile the project
mvn clean compile

# Run HelloWorld
java -cp target/classes com.aw.tutorial.HelloWorld

# Run Java Basics Tutorial
java -cp target/classes com.aw.tutorial.JavaBasicsTutorial

# Run JDK/JRE/JVM Explanation
java -cp target/classes com.aw.tutorial.JdkJreJvmExplanation
```

### Run Test Examples
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=SeleniumJvmExample

# Run with TestNG suite
mvn test -DsuiteXmlFile=testng.xml
```

### Check Java Version and JVM Info
```bash
# Check Java version
java -version

# Check JVM details
java -XshowSettings:properties -version
```

## Key Takeaways

1. **JDK** is needed for development (compiling code with dependencies)
2. **JRE** is needed for execution (running your automation tests)
3. **JVM** manages memory and resources (crucial for WebDriver and API testing)
4. **Project Structure** follows Maven conventions for proper dependency management
5. **Memory Management** is important for automation (WebDriver instances, API responses)
6. **Class Loading** is how Maven dependencies become available to your code

## Common Issues and Solutions

### Issue: "java: command not found"
**Solution**: Install JDK and add to PATH

### Issue: "WebDriver not found"
**Solution**: Use WebDriverManager or ensure driver is in PATH

### Issue: "OutOfMemoryError"
**Solution**: Increase JVM heap size: `-Xmx2g`

### Issue: "ClassNotFoundException"
**Solution**: Check Maven dependencies and classpath

This tutorial provides the foundation for understanding how Java concepts apply to automation testing with Selenium and Rest Assured.

