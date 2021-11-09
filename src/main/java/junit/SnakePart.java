package junit;

import java.awt.*;

public class SnakePart{
  public int xCord;
  public int yCord;
  public int width;
  public int height;

  public SnakePart(){
    this.xCord=0;
    this.yCord=0;
    this.width=0;
    this.height=0;
  }

  public SnakePart(int xCord, int yCord, int tileSize){
    this.xCord = xCord;
    this.yCord = yCord;
    this.width = tileSize;
    this.height = tileSize;

  }

  public SnakePart createSnake(){

    SnakePart snake= new SnakePart(xCord,yCord,width);
    return snake;
  }

  public int getXCord(){
    return xCord;
  }
  public void setxCord(int cx) {xCord = cx;}

  public int getYCord(){ return yCord; }
  public void setyCord(int cy) {yCord = cy;}

  public int getWidth(){ return width; }

  public int getHeight(){ return height; }






}
