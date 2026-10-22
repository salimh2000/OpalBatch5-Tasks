package ATMProject;
import java.util.Scanner;

public class ATMProject {

    static Scanner scanner = new Scanner(System.in);

    static double balance = 1000.00;
    static int pin = 1234;
    static int depositCount = 0;
    static double totalDeposits = 0.0;
    static int withdrawalCount = 0;
    static double totalWithdrawals = 0.0;

    public static boolean login(){
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter PIN: ");
            int input = scanner.nextInt();
            if (input == pin) {
                System.out.println("Welcome!");
                return true;
            }
            attempts++;
            System.out.println("Wrong PIN. Attempts left: " + (3 - attempts));
        }
        System.out.println("Card locked");
        return false;
    }

    public static void menu(){
        int choice;

        do {
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account tier");
            System.out.println("5. Savings projection");
            System.out.println("6. Receipt summary");
            System.out.println("7. Change PIN");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    accountTier();
                    break;
                case 5:
                    savingsProjection();
                    break;
                case 6:
                    receiptSummary();
                    break;
                case 7:
                    changePin();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Error -> Please choose 0-7.");
            }
        } while (choice != 0);
    }

    public static void checkBalance(){
        System.out.printf("Balance: %.2f%n", balance);
    }

    public static void deposit(){
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= 5000){
        balance += amount;
        depositCount++;
        totalDeposits += amount;
        String message = String.format("New Balance: %.2f", balance);
        System.out.println(message);
        } 
        else
        {
        System.out.println("Error Invalid deposit.");
        }
    }

    public static void withdraw(){
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        double fee;

        if (amount <= 0){
            System.out.println("Amount must be greater than 0.");
            return;
        }
        if (amount % 10 != 0){
            System.out.println("Amount must be a multiple of 10.");
            return;
        }
        if (totalWithdrawals + amount > 1000){
            System.out.println("The withdrawal limit is 1000.");
            return;
        }

        if (amount <= 500){
            fee = 2.00;
        } 
        else 
        {
            fee = 5.00;
        }

        if (balance < amount + fee) {
            System.out.println("Insufficient balance, including the fee.");
            return;
        }

        balance -= amount + fee;
        withdrawalCount++;
        totalWithdrawals += amount;

        System.out.println(String.format("Fee: %.2f", fee));
        System.out.println(String.format("New Balance: %.2f", balance));
    }

    public static void accountTier(){
        if (balance < 1000) {
            System.out.println("Tier: Bronze, interest rate: 1%");
        } else if (balance < 5000) {
            System.out.println("Tier: Silver, interest rate: 2%");
        } else if (balance < 20000) {
            System.out.println("Tier: Gold, interest rate: 3%");
        } else {
            System.out.println("Tier: Platinum, interest rate: 4%");
        }
    }

    public static void savingsProjection(){
        System.out.print("Enter number of years (1-10): ");
        int years = scanner.nextInt();
        double rate = 0.01;
        double amount = balance;

        if (balance >= 1000 && balance < 5000){
            rate = 0.02;
        } else if (balance >= 5000 && balance < 20000){
            rate = 0.03;
        } else if (balance >= 20000){
            rate = 0.04;
        }

        for (int i = 1; i <= years; i++){
            amount = amount * (1 + rate);
            System.out.println(String.format("Year " + i + ": %.2f", amount));
        }
    }

    public static void receiptSummary(){
        System.out.println("Deposits: " + depositCount + ", total: " + String.format("%.2f", totalDeposits));
        System.out.println("Withdrawals: " + withdrawalCount + ", total: " + String.format("%.2f", totalWithdrawals));
        System.out.println("Balance: " + String.format("%.2f", balance));
    }

    public static void changePin(){
        System.out.print("Enter old PIN: ");
        int oldPin = scanner.nextInt();

        if (oldPin != pin){
            System.out.println("Incorrect.");
            return;
        }

        System.out.print("Enter new PIN: ");
        int newPin = scanner.nextInt();

        if (newPin < 1000 || newPin > 9999){
            System.out.println("PIN must be 4 digits.");
            return;
        }

        System.out.print("Confirm new PIN: ");
        int confirmPin = scanner.nextInt();
        if (newPin == confirmPin){
            pin = newPin;
            System.out.println("PIN changed.");
        } 
        else
        {
            System.out.println("Error PINs do not match.");
        }

    }

    public static void main(String[] args){
        if (login()) {
            menu();
        }
        scanner.close();
    }
}
