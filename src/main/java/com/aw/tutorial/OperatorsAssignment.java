package com.aw.tutorial;

public class OperatorsAssignment {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // Perform arithmetic operations
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int division = a / b;
        int remainder = a % b;

        // Print the results
        System.out.println("a + b = " + sum);
        System.out.println("a - b = " + difference);
        System.out.println("a * b = " + product);
        System.out.println("a / b = " + division);
        System.out.println("a % b = " + remainder);

        int x = 5;
        int y = 10;

        // Using relational operators in if statements
        if (x < y) {
            System.out.println("x is less than y");
        }

        if (x == y) {
            System.out.println("x is equal to y");
        } else {
            System.out.println("x is not equal to y");
        }

        if (x != y) {
            System.out.println("x and y are different");
        }

        if (x > y) {
            System.out.println("x is greater than y");
        } else {
            System.out.println("x is not greater than y");
            
        }

        //Logical Operators
        boolean hasPen = true;
        boolean hasBook = false;

        // Logical AND
        System.out.println("hasPen && hasBook: " + (hasPen && hasBook));

        // Logical OR
        System.out.println("hasPen || hasBook: " + (hasPen || hasBook));

        // Logical NOT
        System.out.println("!hasBook: " + (!hasBook));


        //Assignment Operator
        int num = 10;
        System.out.println("Initial value: " + num);

        num += 5; // Adds 5 
        System.out.println("After num += 5: " + num);

        num -= 2; // Subtracts 2 
        System.out.println("After num -= 2: " + num);

        num *= 3; // Multiplies by 3 
        System.out.println("After num *= 3: " + num);

        num /= 4; // Divides by 4 
        System.out.println("After num /= 4: " + num);


        //Ternary Operator
        int age = 18;

        String result = (age >= 18) ? "Adult" : "Minor";

        // Print the result
        System.out.println("Age: " + age);
        System.out.println("Status: " + result);
    }
}

    


