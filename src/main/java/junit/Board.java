package junit;

import org.json.JSONObject;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;


public class Board extends JPanel implements Runnable, KeyListener {

  private static final long serialVersionUID = 1L;
  public int WIDTH = 500, HEIGHT = 500;
  public Color color;
  public boolean boardDraw = false;
  public int puntuation = 0;
  String username = "";
  public boolean running, updatingSnake, updatingGame, firstSnake, createNewApple = false, isOut, right = true, left = false, up = false, down = false;
  private Thread thread;
  private SnakePart s;
  private ArrayList<SnakePart> snake;
  private ArrayList<Apple> apples;
  private Random r = new Random();
  boolean snakeUpdated;
  public int xCordSnake = 10, yCordSnake = 10, tileSize = 5, ticks = 0, miliseconds = 750000;

  public int getWidth(){return WIDTH;}
  public int getHeight(){return HEIGHT;}
  boolean applesInBoard = false;
  public boolean getUpdatingGame() { return updatingGame;}
  public boolean getFirstSnake() { return firstSnake;}
  public boolean getCreateNewApple() { return createNewApple;}

  public void setColor(Color c){ color=c;}

  public boolean getIsRunning(){ return running;}

  public ArrayList<Apple> getApples(){ return apples;}
  public ArrayList<SnakePart> getSnake(){ return snake;}


  public void setxCordSnake(int cord){xCordSnake =cord;}
  public void setyCordSnake(int cord){yCordSnake =cord;}
  public int getxCordSnake(){return xCordSnake;}
  public int getyCordSnake(){return yCordSnake;}

  public int getTileSize(){return tileSize;}
  public void setCreateNewApple(boolean var){createNewApple=var;}

  @Override
  public void run() {
    while(running) {
      try {
        update();
      } catch (IOException e) {
        e.printStackTrace();
      }
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
    g.drawString("Puntuacio " + puntuation, 420,12);
    boardDraw = true;
  }

  public void start(){
    running = true;
    thread = new Thread(this);
    thread.start();
  }

  public void stop() throws IOException {
    running=false;
    JSON json = new JSON();
    json.saveJSON(username,puntuation);
    //parar el thread
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


public void update() throws IOException {

  if(snake.size() == 0){
    s = new SnakePart(xCordSnake, yCordSnake, 10);
    snake.add(s);
    firstSnake = true;
  }
  ticks++;

  updateSnake(right,left,down,up);

  applesInBoard =comproveApplesInBoard();

  if(applesInBoard == true){
    eat();
  }

  if(comproveLimits() == true){
    stop();
  }

  if(snakeHitWithHim()==true){
    stop();
  }

  updatingGame = true;
}

  public void updateSnake(boolean right, boolean left, boolean down, boolean up){

    snakeUpdated = false;
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
        snakeUpdated = true;
      }
      //updatingSnake = true;

    }

  }

  public boolean comproveLimits() throws IOException {
    boolean outOfLimits = false;
    if(xCordSnake < 0 || xCordSnake > 49 || yCordSnake < 0 || yCordSnake > 49){
      outOfLimits = true;
    }
    return outOfLimits;
  }

  public boolean comproveApplesInBoard(){

    if(apples.size() == 0){   //si no hay ninguna manzana en el tablero te crea una random y la añade al array para printearla

      Apple apple = new Apple();
      apples.add(apple);
      createNewApple = true;
    }

    return createNewApple;
  }

  public void eat(){
    for (int i=0; i< apples.size();i++){
      if(snake.get(snake.size() - 1).getXCord() == apples.get(i).getxCord() && snake.get(snake.size()-1).getYCord() == apples.get(i).getyCord())
        grow();
    }
  }

  public void grow(){
    tileSize++;
    puntuation++;
    miliseconds = miliseconds + 5000;
    if(apples.size() != 0){
      apples.remove(0);
    }
    Apple apple = new Apple();
    apples.add(apple);
  }


  public boolean snakeHitWithHim(){
    boolean hit = false;
    for (int i = 0; i < snake.size(); i++){
      if(xCordSnake == snake.get(i).getXCord() && yCordSnake == snake.get(i).getYCord()){
        if(i != snake.size() -1 ){  //comprovar que no acaba de empezar la partida, sino pararia justo al empezar
          hit = true;
        }
      }
    }
    return hit;
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
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}

