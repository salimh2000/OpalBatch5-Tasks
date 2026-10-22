package ArraysTask;
import java.util.Scanner;

public class ArraysTask {
    static Scanner scanner = new Scanner(System.in);

    //Question 1: Sum and Average
    static int sumArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
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
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    static int findMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

     public static void main(String[] args) {
        int[] numbers = {12, 7, 25, 3, 18, 9, 30, 14};

        System.out.println("Sum: " + sumArray(numbers));
        System.out.println("Average: " + averageArray(numbers));

        System.out.println("Max: " + findMax(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Difference: " + (findMax(numbers) - findMin(numbers)));



        
    }
}
