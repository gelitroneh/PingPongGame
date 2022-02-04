package pong;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

/**
*
* @author ANDER PARDO, ADRIAN YEPEZ
* PROYECTO FINAL PROGRAMACION
* JUEGO PING PONG
*/

//Clase que configura la pnatalla de juego
public class TableroJuego extends JPanel {
	
	//Declaracion de los objetos a usar
	Pelota pelota = new Pelota();	
	Raqueta r1 = new Raqueta(10, 200);
	Raqueta r2 = new Raqueta(794 - 10 - Raqueta.ANCHO, 200);

	//Establece el color del fondo
    public TableroJuego() {
    	
        setBackground(Color.BLACK);
        
    }
    
    //Pinta los objetos que apareceran en la ejecucion del codigo
    @Override
    public void paintComponent(Graphics g){
    	
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setPaint(Color.WHITE);
        dibujarPuntaje(g2);
        dibujar(g2);
        
    }
    
    //Pinta los objetos que apareceran en la ejecucion del codigo
    public void dibujar(Graphics2D g) {
    	Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());

    	g.draw(linea);
    	    	
    	g.fill(r1.getRaqueta());
    	actualizar();
    	
    	g.fill(r2.getRaqueta());
    	actualizar();
    	
    	g.fill(pelota.getPelota());
    	actualizar();
    	
    }
    
    //Permite que el movimiento de la pelota y de las raquetas sea fluido
    public void actualizar() {
    	
    	pelota.mover(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()));
    	
    	r1.moverR1(getBounds());    	
    	r2.moverR2(getBounds());
    	
    }
    
    //Muestra el puntaje de los usuarios
    private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);

        g1.drawString(Integer.toString(pelota.getScore1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(pelota.getScore2()), (float) getBounds().getCenterX() + 25, 30);
        if (pelota.getScore1() == 5) {
            g.drawString("ADRIAN WINS", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
        if (pelota.getScore2() == 5) {
            g.drawString("ANDER WINS", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
    }
    
    //Capta el choque de la pelota con las raquetas para asi manejar el movimiento de la misma pelota
    private boolean colision(Rectangle2D g) {
    	return pelota.getPelota().intersects(g);
    }
    
}
