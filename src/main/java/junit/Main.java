package junit;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Main {

  public Main(){

    JFrame window = new JFrame();
    Board board = new Board();


    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    window.pack();
    window.setVisible(true);


  }

  public static void main(String[] args){

    new Main();

  }

}
