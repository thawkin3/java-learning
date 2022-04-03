// https://pressbooks.howardcc.edu/jrip3/chapter/so-you-want-to-win-plinko/

public class PlinkoGame {
  private static int numberOfBoardColumns = 9;
  private static int numberOfBoardRows = 13;

  public static void main(String[] args) {
    System.out.println("Hello PlinkoGame");
    dropPlinkoChips(10);
  }

  private static void dropPlinkoChips(int numberOfChips) {
    if (numberOfChips < 1) {
      dropPlinkoChip();
    } else {
      for (int i = 0; i < numberOfChips; i++) {
        dropPlinkoChip();
      }
    }
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
}
