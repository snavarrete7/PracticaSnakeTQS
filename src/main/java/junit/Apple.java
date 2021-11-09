package junit;

import java.awt.*;
import java.util.Random;

public class Apple {
  public int xCord;
  public int yCord;
  public int width;
  public int height;

  public Apple(){
    Random rand = new Random(System.currentTimeMillis());
    double randX = Math.floor(49 * rand.nextDouble());
    double randY = Math.floor(49 * rand.nextDouble());
    this.xCord = (int) randX;
    this.yCord =(int) randY;
    this.width = 10;
    this.height = 10;

  }
  public Apple(int xCord, int yCord, int size){
    this.xCord = xCord;
    this.yCord = yCord;
    this.width = size;
    this.height = size;
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





}
