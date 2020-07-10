import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class JSONToSound extends PApplet {



//##############################//
//########## @_Clipi_ ##########//
//##############################//


//##########################################################################################################//
int resolution = 4186; //########## ESTE TIENE QUE SER EL MISMO QUE HAS USADO EN EL OTRO PROGRAMA ##########//
//##########################################################################################################//



JSONObject json;

int soundIndex = 0;
AudioSample sound;

int resolution128;



public void setup() {
  
    
  try {
    json = loadJSONObject("../../data.json");
  } catch (NullPointerException e) {
    println("------------------------------------------");
    println("Ha habido un problema al cargar el archivo");
    println("------------------------------------------");
    noLoop();
    exit();
    return;
  }
  sound = new AudioSample(this, resolution, false, PApplet.parseInt(27.5f*resolution));
  resolution128 = resolution/128;
  
  background(0);

}

public void draw() {
  createSound();
}
// Cargar los valores de data.json, convertirlos a audio y tocar el audio indefinidamente hasta que se cierre el programa
public void createSound() {
  
  int counter = 0;
  while (counter < resolution128) {
    if (soundIndex >= resolution) {
      
      println("Sonido cargado correctamente");
      
      sound.loop();
      noLoop();
      
      println("Programa completado");
      return;
    }
    
    float value;
    try {
      value = json.getFloat(str(soundIndex));
    } catch(RuntimeException e) {
      background(255, 0, 0);
      exit();
      return;
    }
    
    for (int i = (soundIndex-16)*width/resolution; i <= soundIndex*width/resolution; i++) {
      for (int j = 0; j < height; j++) {
        set(i, j, -16711936);
      }
    }
    
    sound.write(soundIndex, value);
    
    soundIndex++;
    counter++;
  }
  
  
}
  public void settings() {  size(512, 512); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "JSONToSound" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
