// https://pressbooks.howardcc.edu/jrip3/chapter/so-you-want-to-win-plinko/
import java.util.Arrays;
import java.util.HashMap;

public class PlinkoGame {
  private static int numberOfBoardColumns = 9;
  private static int numberOfBoardRows = 13;

  public static void main(String[] args) {
    System.out.println("Hello PlinkoGame");
    double[] results = dropPlinkoChips(10);
    System.out.println(Arrays.toString(results));
    // generate frequency of each slot result
    generateFrequencies(results);
    // print expected results compared to actual results
  }

  private static double[] dropPlinkoChips(int numberOfChips) {
    double[] results = new double[numberOfChips];

    for (int i = 0; i < numberOfChips; i++) {
      results[i] = dropPlinkoChip();
    }

    return results;
  }

  private static double dropPlinkoChip() {
    System.out.println("Dropping a Plinko chip!");
    double chipX = 5.0;
    final double moveLeftAmount = -0.5;
    final double moveRightAmount = 0.5;
    final double leftMostColumn = 1.0;
    final double rightMostColumn = 9.0;

    // The chip is always in column 5 (chipX = 5) for row 1 (chipY = 1)
    for (int chipY = 1; chipY < numberOfBoardRows; chipY++) {
      double previousChipX = chipX;

      if (chipX == leftMostColumn) {
        // Chip is already on the very left side of the board and can only move right
        chipX += moveRightAmount;
      } else if (chipX == rightMostColumn) {
        // Chip is already on the very right side of the board and can only move left
        chipX += moveLeftAmount;
      } else {
        // Chip is able to move either left or right
        double randomNumber = Math.random();
        double movementX = randomNumber > 0.5 ? moveRightAmount : moveLeftAmount;
        chipX += movementX;
      }

      System.out.println("Starting in " + chipY + ", " + previousChipX + "; moved to " + (chipY + 1) + ", " + chipX);
    }

    System.out.println("Final chipX: " + chipX);
    return chipX;
  }

  private static void generateFrequencies(double[] results) {
    HashMap<Double, Integer> frequencies = new HashMap<Double, Integer>();

    frequencies.put(1.0, 0);
    frequencies.put(2.0, 0);
    frequencies.put(3.0, 0);
    frequencies.put(4.0, 0);
    frequencies.put(5.0, 0);
    frequencies.put(6.0, 0);
    frequencies.put(7.0, 0);
    frequencies.put(8.0, 0);
    frequencies.put(9.0, 0);

    for (double result : results) {
      frequencies.put(result, frequencies.get(result) + 1);
    }

    System.out.println(frequencies);

    for (double i : frequencies.keySet()) {
      System.out.println("key: " + i + " value: " + frequencies.get(i));
    }
  }
}
