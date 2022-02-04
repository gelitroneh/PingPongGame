package pong;

import java.applet.AudioClip;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Audio.Audio;

/**
*
* @author ANDER PARDO, ADRIAN YEPEZ
* PROYECTO FINAL PROGRAMACION
* JUEGO PING PONG
*/

public class Pelota{
	
	//Atributos y variables
	private double X = 0;
	private static double Y = 0;
	private double dx = 1, dy = 1;
	private static final int ANCHO = 15, ALTO = 15;
	
	private int score1 = 0, score2 = 0;
	public static boolean finJuego = false;
	
	//Instanciamiento de la clase audio
	Audio audio = new Audio();
    AudioClip rebote_1=audio.getAudio("/Audio/rebote_pelota1.wav");
    AudioClip rebote_2=audio.getAudio("/Audio/rebote_pelota2.wav");
    AudioClip falta=audio.getAudio("/Audio/falta.wav");
	
    //Establece la forma de la pelota en la pantalla
	public Rectangle2D getPelota() {
		
		return new Rectangle2D.Double(X, Y, ANCHO, ALTO);
		
	}
	
	//Metodo encargadoo de el movimiento de la pelota
	@SuppressWarnings("deprecation")
	public void mover(Rectangle limite, boolean colisionR1, boolean colisionR2) {
		
		X += dx;
		Y += dy;
		
		if(colisionR1) {
			
			dx =- dx;
			X = 20;
			//Ejecucion de un archivo de sonido
			rebote_1.play();
		}
		
		if(colisionR2) {
			
			dx =- dx;			
			X = 755;
			//Ejecucion de un archivo de sonido
			rebote_1.play();
			
		}
		
		if(X + ANCHO >= limite.getMaxX()) {
			
			score1 ++;
			X = limite.getCenterX();
			Y = limite.getCenterY();
			dx =- dx;
			//Ejecucion de un archivo de sonido
			falta.play();
			
		}
		
		if(Y + ALTO >= limite.getMaxY()) {
			
			Y = limite.getMaxY() - ALTO;
			dy =- dy;
			//Ejecucion de un archivo de sonido
			rebote_2.play();
			
		}
		
		if(X < limite.getMinX()) {
			
			score2 ++;
			
			X = limite.getCenterX();
			Y = limite.getCenterY();
			dx =- dx;
			//Ejecucion de un archivo de sonido
			falta.play();
		}
		
		if(Y < limite.getMinX()) {
			
			Y = limite.getMinY();
			dy =- dy;
			//Ejecucion de un archivo de sonido
			rebote_2.play();
		}
	}
	
	//Metodos que retornan la puntuacion
	public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

}

