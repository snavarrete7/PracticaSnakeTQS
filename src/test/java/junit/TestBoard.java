package junit;
import junit.CONTROLADOR.Board;
import junit.MODEL.JSON;
import junit.VISTA.Apple;
import junit.VISTA.SnakePart;
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
    assertEquals(board.getFirstSnake(),true);      //primera snake creada
  }

  @Test
  public void testSnakeUpdatesMovementToRight(){

    board.right = true;
    board.left = false;
    board.down = false;
    board.up = false;

    board.ticks = board.miliseconds + 10000;     //forzamos la actualizacion del juego para poder actualizar el movimiento (hacemos que los tiks sean mas grandes que el periodo de actualizacion)
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

    board.ticks = board.miliseconds + 10000;    //forzamos la actualizacion del juego para poder actualizar el movimiento (hacemos que los tiks sean mas grandes que el periodo de actualizacion)
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

    board.ticks = board.miliseconds + 10000;   //forzamos la actualizacion del juego para poder actualizar el movimiento (hacemos que los tiks sean mas grandes que el periodo de actualizacion)
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

    board.ticks = board.miliseconds + 10000;   //forzamos la actualizacion del juego para poder actualizar el movimiento (hacemos que los tiks sean mas grandes que el periodo de actualizacion)
    board.updateSnake(board.right,board.left,board.down,board.up);

    int xCordSnake = board.getxCordSnake();
    int yCordSnake = board.getyCordSnake();

    assertEquals(10,xCordSnake);
    assertEquals(9,yCordSnake);

  }

  @Test
  public void testComproveApplesInBoardReturnTrue(){

    boolean resultat = board.comproveApplesInBoard();   //si no hay manzanas en el tablero devuelve true porque ha creado una nueva
    assertEquals(true,resultat);

  }

  @Test
  public void testComproveApplesInBoardReturnFalse(){

    board.setCreateNewApple(false);
    for(int i=0;i<5;i++){                //bucle para forzar que se añadan "i" manzanas en el tablero
      Apple apple = new Apple();
      board.getApples().add(apple);
    }                                    //se comprueba que no puede haber mas de una manzana en el tablero, por lo tanto devuelve false

    boolean resultat = board.comproveApplesInBoard();

    assertEquals(false,resultat);

  }

  @Test
  public void testIsIn() throws IOException {

    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);

  }

  //Tests valorer limites del 1 al 10
  @Test
  public void testIsOut1() throws IOException {

    board.setxCordSnake(50);
    board.setyCordSnake(50);
    board.start();
    board.update();
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, true);
    assertEquals(board.getIsRunning(),false);

  }

  @Test
  public void testIsOut2() throws IOException {

    board.setxCordSnake(49);
    board.setyCordSnake(49);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, false);
  }

  @Test
  public void testIsOut3() throws IOException {

    board.setxCordSnake(0);
    board.setyCordSnake(0);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, false);
  }

  @Test
  public void testIsOut4() throws IOException {

    board.setxCordSnake(-1);
    board.setyCordSnake(-1);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, true);
  }
  @Test
  public void testIsOut5() throws IOException {

    board.setxCordSnake(20);
    board.setyCordSnake(20);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, false);
  }
  @Test
  public void testIsOut6() throws IOException {

    board.setxCordSnake(35);
    board.setyCordSnake(35);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, false);
  }
  @Test
  public void testIsOut7() throws IOException {

    board.setxCordSnake(1);
    board.setyCordSnake(1);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, false);
  }
  @Test
  public void testIsOut8() throws IOException {

    board.setxCordSnake(48);
    board.setyCordSnake(48);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),true);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, false);
  }
  @Test
  public void testIsOut9() throws IOException {

    board.setxCordSnake(-100);
    board.setyCordSnake(-100);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, true);
  }
  @Test
  public void testIsOut10() throws IOException {

    board.setxCordSnake(100);
    board.setyCordSnake(100);
    board.start();
    board.update();
    assertEquals(board.getIsRunning(),false);
    boolean outOfLimits = board.comproveLimits();
    assertEquals(outOfLimits, true);
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


    assertNotEquals(11, xNewCordApple);         //compruebas que la posicion de la nueva apple no sea igual a la anterior
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
    ArrayList<SnakePart> snake = board.getSnake();        //forzamos la posicion de la cabeza con una de su cuerpo para forzar el choque

    while(snake.size() < 2){   //bucle para evitar errores de creacion de la snake
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
    ArrayList<SnakePart> snake = board.getSnake();     //realizamos lo contrario que en la anterior

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
  public void testJSON() throws IOException {     //test para comprobar que se guarda bien la base de datos

    board.username = "Test";
    board.puntuation = 10;
    JSON jsonclass = new JSON();
    JSONObject json = jsonclass.readJSON();
    jsonclass.saveJSON(board.username,board.puntuation);

    int testPuntuation = (int)json.get(board.username);
    assertEquals(board.puntuation, testPuntuation);

  }

  @Test
  public void testRemoveLastPartSnake(){ //Test para comprobar la funcion moveSnake()

    for(int i=0; i<5;i++){
      SnakePart part = new SnakePart(10,10,10);      //creacion de snake de 5 posiciones
      board.getSnake().add(part);
    }
    board.ticks = board.miliseconds + 10000;         //forzamos la actualizacion
    board.tileSize = 1;
    board.updateSnake(true,false,false,false);   //si el tamaño del array snake es mayor que su tamaño real (tileSize) quiere decir
                                                                     //que la snake se ha movido para una posicion entonces se elimina la parte de la cola para mantener el tamaño real
    assertEquals(true, board.snakeUpdated);                   //y causar el efecto de movimiento
  }

  @Test
  public void testDontRemoveLastPartSnake(){
    ArrayList<SnakePart> snake = board.getSnake();
    board.tileSize = snake.size() + board.tileSize;
    assertEquals(false, board.snakeUpdated);
  }


}

