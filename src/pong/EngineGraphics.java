package pong;

/**
*
* @author ANDER PARDO, ADRIAN YEPEZ
* PROYECTO FINAL PROGRAMACION
* JUEGO PING PONG
*/

//Clase que gestiona la ejecucion del juego y su fluidez
public class EngineGraphics extends Thread {

	//Atributos
    private final TableroJuego lamina;

    public EngineGraphics(TableroJuego lamina) {
        this.lamina = lamina;
    }

    @Override
    public void run() {
    	//Mientras el metodo finJuego de la clase pelota no retorne un valor true
    	//El ciclo se seguira ejecutando.
        while (!Pelota.finJuego) {
        	lamina.repaint();
            try {
                //Paint Velocity 
            	//Controla la velocidad de la pelota
                Thread.sleep(8);
            } catch (Exception ex) {
            	//Mensaje que se mostrara si existe un error
                System.out.println("error in graphics engine: " + ex.getMessage());
            }
        }
    }
}

