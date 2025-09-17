package com.aw.tutorial;

public class ExpressionAssignment {

    public static void main(String[] args) {
        int length = 5;
        int breadth = 3;
       // Calculate area
        int area = length * breadth; 
        System.out.println("Area of the rectangle: " + area);

        int marks1 = 80;
        int marks2 = 90;
        int marks3 = 70;

        // Calculate average
        int average = (marks1 + marks2 + marks3) / 3;

        // Print the result
        System.out.println("Average marks: " + average);

        
// String Expression
        String firstName = "Monica";
        String lastName = "Verma";

        // Combine with newline and space
        String fullName = firstName + " " + lastName;

        // Print the full name
        System.out.println(fullName);

//Combined Expression
int totalMarks = 500;
        int obtained = 420;

        // Calculate percentage
        int percentage = (obtained * 100) / totalMarks;

        // Print the result
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Obtained Marks: " + obtained);
        System.out.println("Percentage: " + percentage + "%");



    }
}
 