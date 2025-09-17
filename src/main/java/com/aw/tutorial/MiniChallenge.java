package com.aw.tutorial;

public class MiniChallenge {
        public static void main(String[] args) {
            int maths = 75;
            int science = 60;
            int english = 80;
    
            // Calculate total and percentage
            int totalMarks = maths + science + english;
            double percentage = (totalMarks * 100.0) / 300;
    
            // Use ternary operator to check pass/fail
            String result = (percentage >= 40) ? "Pass" : "Fail";
    
            // Print results
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Percentage: " + percentage + "%");
            System.out.println("Result: " + result);
        }
    }
    
