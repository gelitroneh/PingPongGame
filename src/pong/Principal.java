package pong;

import javax.swing.JFrame;

/**
*
* @author ANDER PARDO
*/

//Clase principal
public class Principal extends Ventana {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

