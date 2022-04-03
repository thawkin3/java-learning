import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
  @Test
  public void addition() {
    assertEquals(3, Main.add(1, 2));
  }

  @Test
  public void subtraction() {
    assertEquals(4, Main.subtract(5, 1));
  }

  @Test
  public void multiplication() {
    assertEquals(10, Main.multiply(5, 2));
  }

  @Test
  public void division() {
    assertEquals(2, Main.divide(6, 3));
  }
}
