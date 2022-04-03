// https://pressbooks.howardcc.edu/jrip3/chapter/so-you-want-to-win-plinko/

public class PlinkoGame {
  private int boardColumns = 9;
  private int boardRows = 13;
  
  public static double dropPlinkoChip() {
    System.out.println("Dropping a Plinko chip!");
    double chipX = 5.0;

    // The chip is always in column 5 (chipX = 5) for row 1 (chipY = 1)
    for (int chipY = 1; chipY < 13; chipY++) {
      double previousChipX = chipX;
      String movementDirection;
      if (chipY % 2 == 0) {
        // Even row
        // Chip is able to move either left or right
        double randomNumber = Math.random();
        double movementX = randomNumber > 0.5 ? 0.5 : -0.5;
        movementDirection = randomNumber > 0.5 ? "right" : "left";
        chipX += movementX;
      } else {
        // Odd row
        if (chipX == 1) {
          // Chip is already on the very left side of the board and can only move right
          chipX = 1.5;
          movementDirection = "right";
        } else if (chipX == 9) {
          // Chip is already on the very right side of the board and can only move left
          chipX = 8.5;
          movementDirection = "left";
        } else {
          // Chip is able to move either left or right
          double randomNumber = Math.random();
          double movementX = randomNumber > 0.5 ? 0.5 : -0.5;
          movementDirection = randomNumber > 0.5 ? "right" : "left";
          chipX += movementX;
        }
      }

      System.out.println("Starting in " + chipY + ", " + previousChipX + "; moved " + movementDirection + " to " + (chipY + 1) + ", " + chipX);
    }

    System.out.println("Final chipX: " + chipX);
    return chipX;
  }

  public static void main(String[] args) {
    System.out.println("Hello PlinkoGame");
    dropPlinkoChip();
  }
}
