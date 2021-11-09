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
  public boolean boardCreated;
  private boolean running, updatingSnake, updatingGame, firstSnake, createNewApple, isOut, right = true, left = false, up = false, down = false;
  private Thread thread;
  private SnakePart s;
  private ArrayList<SnakePart> snake;
  private ArrayList<Apple> apples;
  private Random r = new Random();

  public int xCordSnake = 10, yCordSnake = 10, tileSize = 5, ticks = 0, miliseconds = 550000;

  public int getWidth(){return WIDTH;}
  public int getHeight(){return HEIGHT;}
  public boolean getIsRunning(){ return running;}
  public ArrayList<Apple> getApples(){ return apples;}
  public ArrayList<SnakePart> getSnake(){ return snake;}
  public void setIsRunning(boolean run){running= run;}
  public void setxCordSnake(int cord){xCordSnake =cord;}
  public void setyCordSnake(int cord){yCordSnake =cord;}
  public int getxCordSnake(){return xCordSnake;}
  public int getyCordSnake(){return yCordSnake;}


  public Board(){

    setFocusable(true);
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    addKeyListener(this);
    snake = new ArrayList<SnakePart>();
    apples = new ArrayList<Apple>();


    start();

  }

  @Override
  public void run() {
    while(running) {
      update();
      repaint();
    }

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

}

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}

