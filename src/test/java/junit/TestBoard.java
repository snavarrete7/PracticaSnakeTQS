package junit;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoard {


  @Test
  public void testBoardCreationNotNull(){
    assertNotNull(new Board());

  }

  @Test
  public void testBoardCreationArguments(){

    assertEquals(new Board().getHeight(), 500);
    assertEquals(new Board().getWidth(), 500);

  }

  @Test
  public void testBoardDraw(){
    JFrame window = new JFrame();
    Board board = new Board();
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);

    board.run();
    assertEquals(true, board.boardDraw);

  }

  @Test
  public void testGameIsRunning(){

    JFrame window = new JFrame();
    Board board = new Board();


    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    window.pack();
    window.setVisible(true);
    board.start();
    assertEquals(board.getIsRunning(), true);

  }

  @Test
  public void testGameStopped(){
    JFrame window = new JFrame();
    Board board = new Board();


    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    window.pack();
    window.setVisible(true);

    board.stop();

    assertEquals(board.getIsRunning(),false);
  }

  @Test
  public void testGameIsUpdating(){
    JFrame window = new JFrame();
    Board board = new Board();


    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    window.pack();
    window.setVisible(true);

    board.update();

    assertEquals(board.getUpdatingGame(), true);
  }


  @Test
  public void testFirstSnake(){
    JFrame window = new JFrame();
    Board board = new Board();


    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    window.pack();
    window.setVisible(true);

    board.update();

    assertEquals(board.getFirstSnake(),true);
  }


  @Test
  public void testSnakeUpdatesMovementToRight(){

    Board board = new Board();
    board.right = true;
    board.left = false;
    board.down = false;
    board.up = false;

    board.ticks = board.miliseconds + 10000;
    board.updateSnake(board.right,board.left,board.down,board.up);

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getyCordSnake();

    assertEquals(11,xCordSnake);
    assertEquals(10,yCordSnake);

  }


  @Test
  public void testSnakeUpdatesMovementToLeft(){

    Board board = new Board();
    board.right = false;
    board.left = true;
    board.down = false;
    board.up = false;

    board.ticks = board.miliseconds + 10000;
    board.updateSnake(board.right,board.left,board.down,board.up);

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getyCordSnake();

    assertEquals(9,xCordSnake);
    assertEquals(10,yCordSnake);

  }


  @Test
  public void testSnakeUpdatesMovementToDown(){

    Board board = new Board();

    board.right = false;
    board.left = false;
    board.down = true;
    board.up = false;

    board.ticks = board.miliseconds + 10000;
    board.updateSnake(board.right,board.left,board.down,board.up);

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getyCordSnake();

    assertEquals(10,xCordSnake);
    assertEquals(11,yCordSnake);

  }


  @Test
  public void testSnakeUpdatesMovementToUp(){

    Board board = new Board();

    board.right = false;
    board.left = false;
    board.down = false;
    board.up = true;

    board.ticks = board.miliseconds + 10000;
    board.updateSnake(board.right,board.left,board.down,board.up);

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getyCordSnake();

    assertEquals(10,xCordSnake);
    assertEquals(9,yCordSnake);

  }


}

