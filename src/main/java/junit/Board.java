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



}

