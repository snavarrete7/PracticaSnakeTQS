package junit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TestSnake{

  @Test
  public void testSnakeCreationNotNull() {

    assertNotNull(new SnakePart());

  }

  @Test
  public void testSnakeCreationWithArguments(){

    assertNotNull(new SnakePart(10,10,10).createSnake());
  }


  @Test
  public void testSnakeAtributes(){
    int xCord = 10;
    int yCord = 10;
    int tileSize = 20;

    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getXCord(), xCord);
    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getYCord(), yCord);
    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getWidth(), tileSize);
    assertEquals((new SnakePart(xCord,yCord,tileSize).createSnake()).getHeight(), tileSize);

  }

  @Test
  public void testSnakeDraw(){
    JFrame window = new JFrame();
    Board board = new Board();
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);


    board.run();

    assertEquals(true, board.getSnake().get(0).snakeDraw);


  }

  @Test
  public void testSnakeMovement(){
    JFrame window = new JFrame();
    Board board = new Board();
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);

    while(board.getxCordSnake()== 10 && board.getyCordSnake()== 10){
      board.update();
    }

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getxCordSnake();

    assertNotEquals(10,xCordSnake);
    assertNotEquals(10,yCordSnake);
  }

  @Test
  public void testSnakeStartsMovingOnRight(){
    JFrame window = new JFrame();
    Board board = new Board();
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);

    boolean snakeMovesRight = false;

    while(board.getxCordSnake()== 10 && board.getyCordSnake()== 10){
      board.update();
    }


    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getxCordSnake();

    if(xCordSnake > 10 && yCordSnake > 10){
      snakeMovesRight = true;
    }

    assertEquals(true,snakeMovesRight);
  }

}
