package ArraysTask;
import java.util.Scanner;

public class ArraysTask {
    static Scanner scanner = new Scanner(System.in);

    //Question 1: Sum and Average
    static int sumArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    static double averageArray(int[] arr){
        double avg = (double) sumArray(arr) / arr.length;
        return avg;
    }

    //Question 2: Largest and Smallest
    static int findMax(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    //Question 3: Count and Search
    static int countEven(int[] arr){
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    static int indexOf(int[] arr, int target){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    //Question 4: Reverse the Array
    static int[] reverseArray(int[] arr){
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    //Question 5: Student Grades
    static int[] readGrades(int size){
        int[] grades = new int[size];
        for (int i = 0; i < grades.length; i++){
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
        return grades;
    }
    static int countPassed(int[] grades){
        int passed = 0;
        for (int i = 0; i < grades.length; i++){
            if (grades[i] >= 50) {
                passed++;
            }
        }
        return passed;
    }

     public static void main(String[] args) {
        int[] numbers = {12, 7, 25, 3, 18, 9, 30, 14};

        System.out.println("Sum: " + sumArray(numbers));
        System.out.println("Average: " + averageArray(numbers));

        System.out.println("Max: " + findMax(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Difference: " + (findMax(numbers) - findMin(numbers)));

        System.out.println("Even numbers: " + countEven(numbers));
        System.out.println("Enter a number to search for ");
        int input = scanner.nextInt();
        if (indexOf(numbers, input) == -1){
            System.out.println(input + " not found");
        } 
        else{
            System.out.println(input + " found at index " + indexOf(numbers, input));
        }

        System.out.print("Original: ");
        printArray(numbers);
        System.out.print("\n" + "Reversed: ");
        printArray(reverseArray(numbers));

        System.out.print("\n" + "How many students? ");
        int size = scanner.nextInt();
        int[] grade = readGrades(size);
        int pass = countPassed(grade);
        System.out.println("Passed: " + pass);
        System.out.println("Failed: " + (grade.length - pass));
    }
}
