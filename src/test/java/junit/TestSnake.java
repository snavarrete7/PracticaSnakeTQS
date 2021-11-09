package junit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSnake{

  @Test
  public void TestSnakeCreationNotNull() {

    assertNotNull(new SnakePart());

  }

  @Test
  public void TestSnakeCreationWithArguments(){

    assertNotNull(new SnakePart(10,10,10).createSnake());
  }


  @Test
  public void TestSnakeAtributes(){
    int xCord = 10;
    int yCord = 10;
    int tileSize = 20;

    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getXCord(), xCord);
    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getYCord(), yCord);
    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getWidth(), tileSize);
    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getHeight(), tileSize);

  }

}
