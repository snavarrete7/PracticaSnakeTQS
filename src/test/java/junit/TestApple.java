package junit;
import junit.CONTROLADOR.Board;
import junit.VISTA.Apple;
import junit.VISTA.RandomNumber;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApple {
  @Test
  public void testAppleCreationNotNull() {
    assertNotNull(new Apple());
  }

  @Test
  public void testAppleCreationWithArgument(){
    assertNotNull(new Apple(10,10,10).createApple());
  }

  @Test
  public void testAppleAtributes() {
    int xCord = 20;
    int yCord = 20;
    int tileSize = 15;

    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getxCord(), xCord);
    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getyCord(), yCord);
    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getHeight(), tileSize);
    assertEquals((new Apple(xCord, yCord, tileSize).createApple()).getWidth(), tileSize);

  }


  @Test
  public void testAppleDraw(){
    JFrame window = new JFrame();
    Board board = new Board();
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);

    board.run();
    boolean appleDraw = board.getApples().get(0).appleDraw;  //variable que nos indica cuando se ha dibujado
    assertEquals(true, appleDraw);
  }

  @Test
  public void testAppleCreationNotNullRandom() {
    assertNotNull(new Apple(new RandomNumber()));

  }

}
