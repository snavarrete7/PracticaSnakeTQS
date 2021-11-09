package junit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApple {
  @Test
  public void TestAppleCreationNotNull() {
    assertNotNull(new Apple());

  }

  @Test
  public void TestAppleCreationWithArgument(){
    assertNotNull(new Apple(10,10,10).createApple());


  }

  @Test
  public void TestAppleAtributes() {
    int xCord = 20;
    int yCord = 20;
    int tileSize = 15;

    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getxCord(), xCord);
    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getyCord(), yCord);
    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getHeight(), tileSize);
    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getWidth(), tileSize);

  }




}
