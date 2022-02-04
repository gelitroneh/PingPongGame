package Audio;

import java.applet.AudioClip;

//Clase que toma los archivos de audios especificados para ser reproducidos al ejecutar una accion
public class Audio {

  public AudioClip getAudio(String direccion) {
      return java.applet.Applet.newAudioClip(getClass().getResource(direccion));
  }
 
}

