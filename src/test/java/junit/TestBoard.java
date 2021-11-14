package junit;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestBoard {

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
  public void testBoardCreationNotNull(){
    assertNotNull(new Board());

  }

  @Test
  public void testBoardCreationArguments(){

    assertEquals(new Board().getHeight(), 500);
    assertEquals(new Board().getWidth(), 500);

  }
  /*
  @Test
  public void testBoardDraw() throws IOException {
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

  }*/

  @Test
  public void testGameIsRunning(){


    board.start();
    assertEquals(board.getIsRunning(), true);

  }

  @Test
  public void testGameStopped() throws IOException {


    board.stop();

    assertEquals(board.getIsRunning(),false);
  }

  @Test
  public void testGameIsUpdating() throws IOException {


    board.update();

    assertEquals(board.getUpdatingGame(), true);
  }


  @Test
  public void testFirstSnake() throws IOException {


    board.update();

    assertEquals(board.getFirstSnake(),true);
  }


  @Test
  public void testSnakeUpdatesMovementToRight(){


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

  @Test
  public void testComproveApplesInBoardReturnTrue(){


    boolean resultat = board.comproveApplesInBoard();

    assertEquals(true,resultat);

  }

  @Test
  public void testComproveApplesInBoardReturnFalse(){

    board.setCreateNewApple(false);
    for(int i=0;i<5;i++){
      Apple apple = new Apple();
      board.getApples().add(apple);
    }

    boolean resultat = board.comproveApplesInBoard();

    assertEquals(false,resultat);

  }

  @Test
  public void testIsIn() throws IOException {

    board.setxCordSnake(1);
    board.setyCordSnake(1);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);

  }

  //Tests valors limits del 1 al 10
  @Test
  public void testIsOut1() throws IOException {

    board.setxCordSnake(50);
    board.setyCordSnake(50);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
  }

  @Test
  public void testIsOut2() throws IOException {

    board.setxCordSnake(49);
    board.setyCordSnake(49);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
  }

  @Test
  public void testIsOut3() throws IOException {

    board.setxCordSnake(0);
    board.setyCordSnake(0);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
  }

  @Test
  public void testIsOut4() throws IOException {

    board.setxCordSnake(-1);
    board.setyCordSnake(-1);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
  }
  @Test
  public void testIsOut5() throws IOException {

    board.setxCordSnake(20);
    board.setyCordSnake(20);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
  }
  @Test
  public void testIsOut6() throws IOException {

    board.setxCordSnake(35);
    board.setyCordSnake(35);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
  }
  @Test
  public void testIsOut7() throws IOException {

    board.setxCordSnake(1);
    board.setyCordSnake(1);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
  }
  @Test
  public void testIsOut8() throws IOException {

    board.setxCordSnake(48);
    board.setyCordSnake(48);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
  }
  @Test
  public void testIsOut9() throws IOException {

    board.setxCordSnake(-100);
    board.setyCordSnake(-100);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
  }
  @Test
  public void testIsOut10() throws IOException {

    board.setxCordSnake(100);
    board.setyCordSnake(100);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
  }

  @Test
  public void testSnakeGrows(){

    int initialSize = board.getTileSize();
    board.grow();
    assertNotEquals(initialSize, board.getTileSize());

  }

  @Test
  public void testAppleDisapearAndApearOnANewPositionWhenSnakeEats() throws IOException {

    board.start();
    board.update();

    ArrayList<Apple> apple = board.getApples();

    apple.get(0).setyCord(10);
    apple.get(0).setxCord(11);

    board.grow();

    int xNewCordApple = apple.get(0).getxCord();
    int yNewCordApple = apple.get(0).getyCord();


    assertNotEquals(11, xNewCordApple);
    assertNotEquals(10, yNewCordApple);

  }

  @Test
  public void testCreateNewAppleWhenGameStart() throws IOException {

    board.update();

    assertEquals(board.getCreateNewApple(),true);
  }

  @Test
  public void testSnakeHitWithHimTrue() throws IOException {

    board.update();
    ArrayList<SnakePart> snake = board.getSnake();

    while(snake.size() < 2){
      board.update();
    }
    snake.get(0).xCord = 12;
    snake.get(0).yCord = 12;
    board.xCordSnake = 12;
    board.yCordSnake = 12;
    boolean resultat = board.snakeHitWithHim();

    assertEquals(true,resultat);

  }

  @Test
  public void testSnakeHitWithHimFalse() throws IOException {

    board.update();
    ArrayList<SnakePart> snake = board.getSnake();

    while(snake.size() < 2){
      board.update();
    }
    snake.get(0).xCord = 20;
    snake.get(0).yCord = 20;
    board.xCordSnake = 12;
    board.yCordSnake = 12;
    boolean resultat = board.snakeHitWithHim();

    assertEquals(false,resultat);

  }

  @Test
  public void testIncrementPutuation(){

    Apple apple = new Apple();
    int initialPuntuation = board.puntuation;
    board.grow();
    board.grow();
    int finalPuntuation = board.puntuation;
    board.getApples().add(apple);

    assertNotEquals(initialPuntuation,finalPuntuation);

  }

  @Test
  public void testJSON() throws IOException {

    board.username = "Test";
    board.puntuation = 10;
    JSONObject json = board.readJSON();
    board.saveJSON(board.username,board.puntuation);
    int testPuntuation = (int)json.get(board.username);
    assertEquals(board.puntuation, testPuntuation);

  }

  /*
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
  }*/

  /*
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

  }*/




}

