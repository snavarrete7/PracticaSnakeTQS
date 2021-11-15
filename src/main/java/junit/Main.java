package junit;
import junit.CONTROLADOR.Board;

import javax.swing.*;
import java.util.Scanner;


public class Main {

  public Main(String name){

    JFrame window = new JFrame();
    Board board = new Board();
    board.username=name;

    window.add(board);
    window.setTitle("SnakeGame");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.pack();
    window.setVisible(true);


  }

  public static void main(String[] args){

    System.out.println("Introduce tu username: ");
    Scanner s = new Scanner(System.in);
    String name = s.nextLine();

    System.out.println("AVISO: Pulse INTRO comenzar");

    Scanner s2 = new Scanner(System.in);
    String entrada = s2.nextLine();

    System.out.println("Seleccione rapidamente la ventana emergente del juego");

    new Main(name);

  }

}
