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




}

