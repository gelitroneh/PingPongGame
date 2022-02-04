package pong;

import javax.swing.JFrame;

/**
*
* @author ANDER PARDO, ADRIAN YEPEZ
* PROYECTO FINAL PROGRAMACION
* JUEGO PING PONG
*/

//Creacion de la clase ventana
public class Ventana extends JFrame {

	//Instanciamineto
    TableroJuego lamina;
    Pelota pelota = new Pelota();
    
    //Constructor de la clase ventana
    public Ventana() {
    	
        setTitle("Pong");
        setSize(800, 500);
        setLocationRelativeTo(null); //ubicando la ventana en el centro de la pantalla
        setResizable(false);
        lamina = new TableroJuego();
        add(lamina);
        
        addKeyListener(new EventoTeclado());       
        new EngineGraphics(lamina).start();
        
    }
    
}

