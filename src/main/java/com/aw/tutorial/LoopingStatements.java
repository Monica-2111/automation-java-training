package com.aw.tutorial;

import java.util.Scanner;

public class LoopingStatements {

    public static void main(String[] args) {
        // Loop from 1 to 20
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }

    //Multiplication Table of 5
    int number = 5;
        int i = 1;

        // Print multiplication table of 5
        while (i <= 10) {
            System.out.println(number + " x " + i + " = " + (number * i));
            i++;
}
// Do-while loop to keep asking for input until 0 is entered
Scanner scanner = new Scanner(System.in);
int number1;

do {
    System.out.print("Enter a number : ");
    number1 = scanner.nextInt();
} while (number1 != 0);

System.out.println("Program terminated. You entered 0.");

// Create an array of 5 fruits
String[] fruits = {"Strawberry", "Banana", "Litchi", "Orange", "guava"};

// Print each fruit using enhanced for loop
System.out.println("List of Fruits:");
for (String fruit : fruits) {
    System.out.println(fruit);
}

}
}
