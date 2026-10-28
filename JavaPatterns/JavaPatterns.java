package JavaPatterns;
import java.util.Scanner;

public class JavaPatterns {

    public static void showMenu() {
    System.out.println("===== JAVA PATTERN PAPERS =====");
    System.out.println("1. Hollow Square");
    System.out.println("2. Repeated Number Triangle");
    System.out.println("3. Reverse Number Triangle");
    System.out.println("4. Full Diamond");
    System.out.println("5. Hollow Diamond");
    System.out.println("6. X Pattern");
    System.out.println("7. Hourglass");
    System.out.println("8. Descending Alphabet Triangle");
    System.out.println("9. Odd Number Triangle");
    System.out.println("10. Plus Sign");
    System.out.println("0. Exit");
    }

    // Paper 1: Hollow Square
    public static void hollowSquare(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n; column++) {
                if (row == 1 || row == n || column == 1 || column == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Paper 2: Repeated Number Triangle
    public static void repeatedNumberTriangle(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print(row);
            }
            System.out.println();
        }
    }

    // Paper 3: Reverse Number Triangle
    public static void reverseNumberTriangle(int n) {
        for (int row = n; row >= 1; row--) {
            for (int number = 1; number <= row; number++) {
                System.out.print(number);
            }
            System.out.println();
        }
    }

    // Paper 4: Full Diamond
    public static void fullDiamond(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = n - 1; row >= 1; row--) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Paper 5: Hollow Diamond
    public static void hollowDiamond(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= 2 * row - 1; column++) {
                if (column == 1 || column == 2 * row - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int row = n - 1; row >= 1; row--) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= 2 * row - 1; column++) {
                if (column == 1 || column == 2 * row - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Paper 6: X Pattern
    public static void xPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n; column++) {
                if (row == column || row + column == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // Paper 7: Hourglass
    public static void hourglass(int n) {
        for (int row = n; row >= 1; row--) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = 2; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Paper 8: Descending Alphabet Triangle
    public static void descendingAlphabetTriangle(int n) {
        if (n > 26) {
            System.out.println("For this pattern, n must be 26 or less.");
            return;
        }

        char firstLetter = (char) ('A' + n - 1);

        for (int row = 1; row <= n; row++) {
            for (int column = 0; column < row; column++) {
                System.out.print((char) (firstLetter - column));
            }
            System.out.println();
        }
    }

    // Paper 9: Odd Number Triangle
    public static void oddNumberTriangle(int n) {
        int number = 1;

        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print(number + " ");
                number += 2;
            }
            System.out.println();
        }
    }

    // Paper 10: Plus Sign
    public static void plusSign(int n) {
        if (n % 2 == 0) {
            System.out.println("n must be odd for the plus sign.");
            return;
        }

        int middle = n / 2 + 1;

        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n; column++) {
                if (row == middle || column == middle) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean on = true;

        while (on) {
            showMenu();
            System.out.print("Choose 1-10, or 0 to exit: ");
            int input = scanner.nextInt();

            if (input == 0) {
                on = false;
            } else if (input >= 1 && input <= 10) {
                System.out.print("Enter n: ");
                int n = scanner.nextInt();

                switch (input) {
                    case 1:
                        hollowSquare(n);
                        break;
                    case 2:
                        repeatedNumberTriangle(n);
                        break;
                    case 3:
                        reverseNumberTriangle(n);
                        break;
                    case 4:
                        fullDiamond(n);
                        break;
                    case 5:
                        hollowDiamond(n);
                        break;
                    case 6:
                        xPattern(n);
                        break;
                    case 7:
                        hourglass(n);
                        break;
                    case 8:
                        descendingAlphabetTriangle(n);
                        break;
                    case 9:
                        oddNumberTriangle(n);
                        break;
                    case 10:
                        plusSign(n);
                        break;
                }
            } else {
                System.out.println("Choose a number from 0 - 10.");
            }
        }
        scanner.close();
    }
}
