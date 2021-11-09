package junit;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


public class Board extends JPanel implements Runnable, KeyListener {

  private static final long serialVersionUID = 1L;
  public int WIDTH = 500, HEIGHT = 500;
  public Color color;
  public boolean boardDraw;

  public boolean running, updatingSnake, updatingGame, firstSnake, createNewApple = false, isOut, right = true, left = false, up = false, down = false;
  private Thread thread;
  private SnakePart s;
  private ArrayList<SnakePart> snake;
  private ArrayList<Apple> apples;
  private Random r = new Random();

  public int xCordSnake = 10, yCordSnake = 10, tileSize = 5, ticks = 0, miliseconds = 550000;

  public int getWidth(){return WIDTH;}
  public int getHeight(){return HEIGHT;}

  public boolean getBoardDrawed(){return boardDraw;}
  public boolean getUpdatingSnake() { return updatingSnake;}
  public boolean getUpdatingGame() { return updatingGame;}
  public boolean getFirstSnake() { return firstSnake;}
  public boolean getCreateNewApple() { return createNewApple;}
  public boolean getIsOut() { return isOut;}

  public Color getColor() {
    return color;
  }
  public void setColor(Color c){ color=c;}

  public boolean getIsRunning(){ return running;}

  public ArrayList<Apple> getApples(){ return apples;}
  public ArrayList<SnakePart> getSnake(){ return snake;}

  public void setIsRunning(boolean run){running= run;}
  public void setxCordSnake(int cord){xCordSnake =cord;}
  public void setyCordSnake(int cord){yCordSnake =cord;}
  public int getxCordSnake(){return xCordSnake;}
  public int getyCordSnake(){return yCordSnake;}
  public Thread getThread(){return thread;}
  public int getTileSize(){return tileSize;}
  public void setCreateNewApple(boolean var){createNewApple=var;}

  @Override
  public void run() {
    while(running) {
      update();
      repaint();
    }

  }


  public Board(){

    setFocusable(true);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    addKeyListener(this);
    snake = new ArrayList<SnakePart>();
    apples = new ArrayList<Apple>();


    start();

  }

  public void paint(Graphics g) {
    g.clearRect(0, 0, WIDTH, HEIGHT);

    g.setColor(Color.BLACK);
    setColor(Color.BLACK);

    g.fillRect(0, 0, WIDTH, HEIGHT);

    for(int i = 0; i < WIDTH ; i++){
      g.drawLine( i , 0 , i , HEIGHT);
    }
    for(int i = 0; i < WIDTH ; i++){
      g.drawLine( i , 0 , i , HEIGHT);
    }

    for(int i = 0; i < snake.size() ; i++){
      snake.get(i).draw(g);
    }


    for(int i = 0; i < apples.size(); i++) {
      apples.get(i).draw(g);
    }

    boardDraw = true;
  }



  public void start(){
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  public void stop(){
    running=false;
    //parar el thread
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


public void update(){

  if(snake.size() == 0){
    s = new SnakePart(xCordSnake, yCordSnake, 10);
    snake.add(s);
    firstSnake = true;
  }
  ticks++;

  updateSnake(right,left,down,up);

  boolean applesInBoard =comproveApplesInBoard();

  if(applesInBoard == true){

    //TODO
  }

  updatingGame = true;
}

  public void updateSnake(boolean right, boolean left, boolean down, boolean up){

    if(ticks > miliseconds) {    //cada x milisegundos se actualiza, tambien sirve para medir la velocidad de la snake
      if (right) xCordSnake++;
      if (left) xCordSnake--;
      if (up) yCordSnake--;
      if (down) yCordSnake++;

      ticks = 0;

      s = new SnakePart(xCordSnake, yCordSnake, 10);  ///añadir la parte del snake a la nueva posicion
      snake.add(s);

      if (snake.size() > tileSize) {    ///eliminar la ultima snakePart para seguir manteniendo los mismos snakeParts
        snake.remove(0);
      }
      //updatingSnake = true;

    }

  }

  public boolean comproveApplesInBoard(){

    if(apples.size() == 0){   //si no hay ninguna manzana en el tablero te crea una random y la añade al array para printearla

      Apple apple = new Apple();
      apples.add(apple);
      createNewApple = true;
    }

    return createNewApple;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_RIGHT && !left){
      right = true;
      up = false;
      down = false;
    }

    if(key == KeyEvent.VK_LEFT && !right){
      left = true;
      up = false;
      down = false;
    }

    if(key == KeyEvent.VK_UP && !down){
      left = false;
      up = true;
      right = false;
    }

    if(key == KeyEvent.VK_DOWN && !up){
      down = true;
      left = false;
      right = false;
    }

    if(key == KeyEvent.VK_D && !left){
      right = true;
      up = false;
      down = false;
    }

    if(key == KeyEvent.VK_A && !right){
      left = true;
      up = false;
      down = false;
    }

    if(key == KeyEvent.VK_W && !down){
      left = false;
      up = true;
      right = false;
    }

    if(key == KeyEvent.VK_S && !up){
      down = true;
      left = false;
      right = false;
    }



  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}

