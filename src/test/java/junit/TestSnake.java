package junit;
import junit.CONTROLADOR.Board;
import junit.VISTA.SnakePart;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.IOException;

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

    assertEquals(true, board.getSnake().get(0).snakeDraw);  //variable que nos indica si ha sido dibujado


  }

  @Test
  public void testSnakeMovement() throws IOException {
    JFrame window = new JFrame();
    Board board = new Board();
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);

    while(board.getxCordSnake()== 10 && board.getyCordSnake()== 10){  //mientras el snake esta en la posicion inicial, forzar la actualizacion
      board.update();
    }

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getxCordSnake();

    assertNotEquals(10,xCordSnake);                         //si las cordenadas no son iguales a las iniciales es que se ha movido
    assertNotEquals(10,yCordSnake);
  }

  @Test
  public void testSnakeStartsMovingOnRight() throws IOException {
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

    if(xCordSnake > 10 && yCordSnake > 10){      //las coordenadas nos indican que se haya movido a la derecha al iniciar el juego
      snakeMovesRight = true;
    }

    assertEquals(true,snakeMovesRight);
  }

}
