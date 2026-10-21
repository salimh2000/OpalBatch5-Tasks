package ToolboxApp;

import java.util.Scanner;

public class ToolboxApp {
    static Scanner scanner = new Scanner(System.in);

    public static void menu() {
    System.out.println("1. Celsius to Fahrenheit");
    System.out.println("2. Even or Odd");
    System.out.println("3. Maximum of Three");
    System.out.println("4. Factorial");
    System.out.println("5. Multiplication Table");
    System.out.println("6. Star Triangle");
    System.out.println("7. Prime Check");
    System.out.println("8. Reverse Number");
    System.out.println("9. Number Pyramid");
    System.out.println("0. Exit");
    }

    public static void celsiusToFahrenheit() {
    System.out.print("Enter temperature in Celsius: ");
    double c = scanner.nextDouble();
    System.out.println("Temperature in Fahrenheit: " + (c * 9 / 5 + 32));
    }

    public static void evenOrOdd() {
        System.out.print("Enter Number: ");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } 
        else {
            System.out.println(num + " is odd.");
        }
    }

    public static void maxOfThree() {
        System.out.print("Enter First Number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter Seconde Number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter Third Number: ");
        int num3 = scanner.nextInt();

        if (num1>=num2 && num1>=num3){
            System.out.println(num1);
        }
        else if(num2>=num1 && num2>=num3) {
            System.out.println(num2);
        } else {
            System.out.println(num3);
        }
    }

    public static void factorial() {
        int num;
        do {
            System.out.print("Enter a number from 0 to 15: ");
            num = scanner.nextInt();
            if (num < 0 || num > 15) {
                System.out.println("Invalid number. Please enter a number from 0 to 15.");
            }
        } while (num < 0 || num > 15);
        long factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println(num + "! = " + factorial);
    }

    public static void multiplicationTable() {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        for (int i = 1; i <= 10; i++){
            System.out.println(num + " * " + i + " = " + (num*i) );
        }
    }

    public static void starTriangle() {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int space = 1; space <= rows - i; space++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= 2 * i - 1; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void isPrime() {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        boolean isPrime = true;

        for (int divisor = 2; divisor < num; divisor++) {
            if (num % divisor == 0) {
                isPrime = false;
            }
        }

        if (isPrime && num != 1) {
            System.out.println(num + " is prime.");
        } 
        else 
        {
            System.out.println(num + " is not prime.");
        }
    }

    public static void reverseNumber() {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (num <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        int rev = 0;

        while (num > 0) {
            int i = num % 10;
            rev = rev * 10 + i;
            num = num / 10;
        }

        System.out.println("Reversed number: " + rev);
    }

    public static void numberPyramid() {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int option = 0;
        do{
            menu();
            System.out.println("Choose an option from 0-9:");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    evenOrOdd();
                    break;
                case 3:
                    maxOfThree();
                    break;
                case 4:
                    factorial();
                    break;
                case 5:
                    multiplicationTable();
                    break;
                case 6:
                    starTriangle();
                    break;
                case 7:
                    isPrime();
                    break;
                case 8:
                    reverseNumber();
                    break;
                case 9:
                    numberPyramid();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                System.out.println("Invalid please choose 0-9.");
            }
            System.out.println();
        } while (option != 0);
        
        scanner.close();
    }
}
