import java.util.*;
import java.util.InputMismatchException;

/**
 * The class 'Lucas Numbers' has its constructor and methods to
 * access number's index and value.
 * There are also methods to check if a number is a perfect square
 * and to generate an array of numbers
 */

class LucasNumbers {
    private int index;
    private long value;

    /** Constructor
     *
     * @param index Index of Lucas number
     * @param value Value of Lucas number
     * */

    public LucasNumbers(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Method that returns the index of the Lucas number
     **/
    public long getIndex() {
        return index;
    }

    /**
     * Method that returns the value of the Lucas number
     **/
    public long getValue() {
        return value;
    }

    /**
     * Method that displays a number
     * @return A string representation
     */
    public String toString() {
        return "Lucas number: (" + index + ") = " + value;
    }

    /**
     * Method to check if the value is a perfect square
     * @param value The value to check
     * @return True whether a value is a perfect square
     */
    public static boolean isSquare(long value) {
        if(value < 0) return false;
        long square = (long) Math.sqrt(value);
        return square * square == value;
    }
}

/**
 * This class has the main method to execute the calculations
 */
public class Main {
    /**
     * This method interacts with user to get the right N(number of Lucas number)
     * Also it validates an input, computes the Lucas numbers iteratively
     * and checks if the numbers are perfect squares
     * @param args Command-Line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 0;

        while (true) {
            System.out.println("Enter N (number of Lucas numbers): ");
            try {
                N = in.nextInt();
                if (N > 0) {
                    break;
                } else {
                    System.out.println("There must be aa positive integer");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a valid number");
                in.next();
            }
        }

        long num1 = 1, num2 = 3;
        int currInd = 0;
        System.out.println("    Numbers: ");
        while (currInd < N) {
            long value = num1;
            System.out.printf("Lucas number(%d) -> %d\n", currInd, value);
            if (LucasNumbers.isSquare(value)) {
                System.out.printf(" %d is a square\n", value);
            }
            long num3 = num2 + num1;
            num1 = num2;
            num2 = num3;

            currInd++;
        }
        in.close();
    }
}
