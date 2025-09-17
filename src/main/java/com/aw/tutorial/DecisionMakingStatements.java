package com.aw.tutorial;

import java.time.LocalTime;
import java.util.Scanner;

public class DecisionMakingStatements {
    public static void main(String[] args) {

           //Even or Odd
        int number = 7; 
        if (number % 2 == 0) {
            System.out.println(number + " is Even");
        } else {
            System.out.println(number + " is Odd");
        }

        //Largest Number using if else if else
        int a = 25;
        int b = 42;
        int c = 17;

        if (a > b && a > c) {
            System.out.println("The largest number is: " + a);
        } else if (b > a && b > c) {
            System.out.println("The largest number is: " + b);
        } else{
            System.out.println("The largest number is: " + c);
        } 

//Vowel or Consonant

        Scanner scanner = new Scanner(System.in);

        // Prompt user for a character
        System.out.print("Enter a single alphabet character: ");
        char ch = scanner.next().charAt(0);
       
        // Use switch to check for vowels
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println(ch + " is a vowel.");
                break;
            default:
                System.out.println(ch + " is a consonant.");
        }

//Greeting by Time of the Day
 // Get the current hour (0–23)
 int hour = LocalTime.now().getHour();

 // Determine greeting based on hour
 if (hour >= 4 && hour < 12) {
     System.out.println("Good Morning");
 } else if (hour >= 12 && hour < 17) {
     System.out.println("Good Afternoon");
 } else if (hour >= 17 && hour < 21) {
     System.out.println("Good Evening");
 } else {
     System.out.println("Good Night");
 }

    }

}

