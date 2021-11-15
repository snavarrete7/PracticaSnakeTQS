package junit;
import junit.CONTROLADOR.Board;
import junit.VISTA.Apple;
import junit.VISTA.MockRandomNumber;
import junit.VISTA.SnakePart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestMocks {

  Board board;
  JFrame window;

  @BeforeEach
  public void setUp(){
    board = new Board();
    window = new JFrame();
    board.username = "User";
    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);
  }

  @Test
  public void testRandomMockNumbers(){

    Apple apple = new Apple(new MockRandomNumber());
    double res = apple.calculateRandomApple(45);
    assertEquals(res,25 );
  }

  @Test
  public void testComproveApplesInBoardReturnFalseMock(){

    board.setCreateNewApple(false);
    for(int i=0;i<5;i++){
      Apple apple = new Apple(new MockRandomNumber());
      board.getApples().add(apple);
    }

    boolean resultat = board.comproveApplesInBoard();

    assertEquals(false,resultat);

  }

  @Test
  public void testComproveApplesInBoardReturnTrueMock(){

    Apple a = new Apple(new MockRandomNumber());
    //ArrayList<Apple> apple = board.getApples();
    board.getApples().add(a);
    boolean resultat = board.comproveApplesInBoard();

    assertEquals(true,resultat);

  }

  @Test
  public void testAppleDisapearAndApearOnANewPositionWhenSnakeEatsMock() throws IOException {

    board.start();
    board.update();

    ArrayList<Apple> apple = board.getApples();
    Apple a = new Apple(new MockRandomNumber());
    board.getApples().add(a);

    board.grow();

    int xNewCordApple = apple.get(1).getxCord();
    int yNewCordApple = apple.get(1).getyCord();


    assertNotEquals(25, xNewCordApple);
    assertNotEquals(25, yNewCordApple);

  }

  @Test
  public void testSnakeEatsAppleMock() throws IOException {
    while(board.tileSize != 5){
      board.update();
    }


    Apple app = new Apple(new MockRandomNumber());
    ArrayList<Apple> apple = board.getApples();
    apple.add(app);
    //board.update();
    ArrayList<SnakePart> s = board.getSnake();
    s.get(s.size()-1).setxCord(25);
    s.get(s.size()-1).setyCord(25);
    board.eat();

    assertNotEquals(5, board.tileSize);
  }


  @Test
  public void testSnakeEatsAppleWithMock() throws IOException {
    while(board.tileSize != 5){
      board.update();
    }


    Apple app = new Apple(new MockRandomNumber());
    board.getApples().add(app);
    //board.update();
    board.getSnake().get(board.getSnake().size()-1).xCord = 25;
    board.getSnake().get(board.getSnake().size()-1).yCord = 25;
    board.eat();



    assertNotEquals(5, board.tileSize);

  }

}
