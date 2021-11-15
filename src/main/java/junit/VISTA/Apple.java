package junit.VISTA;

import java.awt.*;
import java.util.Random;

public class Apple {
  public int xCord;
  public int yCord;
  public int width;
  public int height;
  public boolean appleDraw;
  RandomNumber rand;

  public Apple(){
    Random rand = new Random(System.currentTimeMillis());
    double randX = Math.floor(49 * rand.nextDouble());
    double randY = Math.floor(49 * rand.nextDouble());
    this.xCord = (int) randX;
    this.yCord =(int) randY;
    this.width = 10;
    this.height = 10;
    this.appleDraw = false;

  }
  public Apple(int xCord, int yCord, int size){
    this.xCord = xCord;
    this.yCord = yCord;
    this.width = size;
    this.height = size;
  }

  //Contructor para utilizar los mocks
  public Apple(RandomNumber randObject){
    this.rand = randObject;
    double randX = calculateRandomApple(49);
    double randY = calculateRandomApple(49);
    this.xCord = (int) randX;
    this.yCord =(int) randY;
    this.width = 10;
    this.height = 10;
    appleDraw=false;
  }

  public Apple createApple(){

    Apple apple= new Apple(xCord,yCord,width);
    return apple;
  }

  public int getWidth(){return width;}
  public int getHeight(){return height;}
  public int getxCord(){return xCord;}
  public int getyCord(){return yCord;}

  public void setxCord(int cord){ xCord=cord;}
  public void setyCord(int cord){yCord=cord;}

  //Funcion para dibujar el apple
  public void draw(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(xCord * width, yCord * height, width, height);
    appleDraw = true;
  }

  public double calculateRandomApple(int value){

    return rand.calculateRandom(value);

  }


}
