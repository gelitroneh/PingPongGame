package pong;

import java.awt.event.*;

/**
*
* @author ANDER PARDO, ADRIAN YEPEZ
* PROYECTO FINAL PROGRAMACION
* JUEGO PING PONG
*/

//Clase que administra los eventos de teclado que aparezcan
//al ser ejecutado el codigo
public class EventoTeclado extends KeyAdapter {

	//Atributos
	static boolean w, s, up, down;
	
	//Metodo que sera llamado al presionar una tecla de movimiento
	@Override
	public void keyPressed(KeyEvent e) {
		
		int id = e.getKeyCode();
		
		if (id == KeyEvent.VK_W) {
			w = true;
		}
		
		if (id == KeyEvent.VK_S) {
			s = true;
		}
		
		if (id == KeyEvent.VK_UP) {
			up = true;
		}
		
		if (id == KeyEvent.VK_DOWN) {
			down = true;
		}
	}
	
	//Metodo que sera llamado al soltar la tecla presionada
	@Override
	public void keyReleased(KeyEvent e) {
		
		int id = e.getKeyCode();
		
		if (id == KeyEvent.VK_W) {
			w = false;
		}
		
		if (id == KeyEvent.VK_S) {
			s = false;
		}
		
		if (id == KeyEvent.VK_UP) {
			up = false;
		}
		
		if (id == KeyEvent.VK_DOWN) {
			down = false;
		}
	}
}

