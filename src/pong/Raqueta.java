package pong;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
*
* @author ANDER PARDO, ADRIAN YEPEZ
* PROYECTO FINAL PROGRAMACION
* JUEGO PING PONG
*/

//Clase raqueta
public class Raqueta {

	//Atributos
	private int X;
	private int Y;
	static final int ANCHO = 10, ALTO = 40;
	
	//Constructor de objeto raqueta
	public Raqueta(int X, int Y) {
		
		this.X = X;
		this.Y = Y;
		
	}
	
	//Establece forma de raqueta
	public Rectangle2D getRaqueta() {
		
		return new Rectangle2D.Double(X, Y, ANCHO, ALTO);
		
	}
	
	//Metodo que maneja el movimiento de raqueta uno
	public void moverR1(Rectangle limite) {
		
		if(EventoTeclado.w && Y>limite.getMinY()) {
			Y--;
		}
		
		if(EventoTeclado.s &&  Y < limite.getMaxY() - ALTO) {
			Y++;
		}
		
	}
	
	//Metodo que maneja el movimiento de raqueta dos
	public void moverR2(Rectangle limite) {

		if(EventoTeclado.up && Y>limite.getMinY()) {
			Y--;
		}
		
		if(EventoTeclado.down && Y < limite.getMaxY() - ALTO) {
			Y++;
		}
		
	}
}
