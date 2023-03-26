import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DynamicLego {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userInput;
        System.out.println("Input a number of blocks: ");
        while (true) {
            try {
                userInput = input.nextInt();
                if (userInput < 1 || userInput > 300000) {
                    throw new IllegalArgumentException("Number of blocks cannot be less than 1 or greater than 300k");
                }
                input.close();
                break;
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Input valid number of blocks between 1 and 300000: ");
                input.nextLine();
            }
        }

        countPillars(userInput);
    }

    public static void countPillars(int targetSum) {

        BigInteger[] row = new BigInteger[targetSum + 1];

        Arrays.fill(row, BigInteger.ZERO);
        row[0] = BigInteger.valueOf(1);

        for(int i = 1; i < targetSum; i++) {
            for(int j = targetSum; j >= i; j--) {
                row[j] = row[j].add(row[j - i]);
            }
        }

        System.out.println("Number of combinations: " + row[targetSum]);
    }
}
