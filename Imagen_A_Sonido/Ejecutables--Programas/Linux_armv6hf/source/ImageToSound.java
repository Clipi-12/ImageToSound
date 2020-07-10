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

public class ImageToSound extends PApplet {



//##############################//
//########## @_Clipi_ ##########//
//##############################//

//############################################################################################################################################################################################//
//########## RECUERDA QUE LA IMAGEN DEBE SER MENOR O IGUAL A 1024*1024 PÍXELES (DE LO CONTRARIO SE AJUSTARÁ AUTOMÁTICAMENTE), AUNQUE PUEDES CONTACTAR CONMIGO SI NECESITAS ALGO MÁS ##########//
//############################################################################################################################################################################################//


//#########################################################################################################################################################################################//
int resolution = 4186; //########## ESTE VALOR LO PUEDES CAMBIAR A TU GUSTO. MÁS RESOLUCIÓN IMPLICA "MÁS CALIDAD" DE SONIDO || SE ACONSEJA QUE EL NÚMERO SEA UN MÚLTIPLO DE 4186 ##########//
//#########################################################################################################################################################################################//



int task = 0;

PImage img;
PImage image;

int order = 10;
int nodes = PApplet.parseInt(pow(pow(2, order), 2));
int n = -1;

float[] values = new float[nodes];
JSONObject JSONvalues;

AudioSample sound;
int soundIndex = 0;

float height2;
float height5;
int resolution20;



public void setup() {
  
  
  imageMode(CENTER);
  
  img = loadImage("../../input.jpg");
  if (img == null) {
    println("------------------------------------------");
    println("Ha habido un problema al cargar el archivo");
    println("------------------------------------------");
    noLoop();
    exit();
    return;
  }
  float max;
  if (img.width > img.height) {
    max = img.height;
  } else {
    max = img.width;
  }
  float mult = 1024 / max;
  
  image = createImage(1024, 1024, RGB);
  JSONvalues = new JSONObject();
  sound = new AudioSample(this, resolution, false, PApplet.parseInt(27.5f*resolution));
  
  height2 = height/2;
  height5 = height/5;
  resolution20 = PApplet.parseInt(resolution/20);
  
  strokeWeight(1);
  background(0);
  image(img, height2, height2, img.width*mult, img.height*mult);
  loadImageValues();
}


public void draw() {
  
  switch(task) {
    case 0:
    getValues();
    break;
    case 1:
    createSound();
    break;
    case 2:
    saveData();
    break;
  }
  
}
// Cargar los valores, convertirlos a audio y tocar el audio indefinidamente hasta que se cierre el programa
public void createSound() {
  
  int counter = 0;
  while (counter < PApplet.parseInt(map(constrain(mouseX, 0, width), 0, width, 1, resolution/128))) {
    if (soundIndex >= resolution) {
      println("Valores guardados en RAM");
      task = 2;
      return;
    }
    
    float value = 0;
    for (int j = 0; j < nodes; j++) {
      value += values[j]*sin(soundIndex*map(j, 0, nodes, 27.5f, 4186)*TAU/resolution);
    }
    value /= nodes;
    
    stroke(0, 255, 0);
    fill(0, 255, 0);
    rect(soundIndex*width/resolution, height2,  width/resolution, -value);
    for (int i = (soundIndex-16)*width/resolution; i <= soundIndex*width/resolution; i++) {
      for (int j = 0; j < height5; j++) {
        set(i, j, -16711936);
      }
    }
    if (soundIndex%resolution20 == 0) {
      println(str(100*soundIndex/resolution)+"%");
    }
    
    JSONvalues.setFloat(str(soundIndex), value);
    sound.write(soundIndex, value);
    
    soundIndex++;
    counter++;
  }
  
  
}
//Coge el valor de un pixel x, y mediante la curva de Hilbert
public void getValues() {
  
  
  int counter = 0;
  while (counter < PApplet.parseInt(map(constrain(mouseX, 0, width), 0, width, 1, nodes/128))) {
  if (n+1 < nodes) {
    n++;
  } else {
    task = 1;
    break;
  }
  
  PVector actual = hilbert(n);
  int value = (image.get(PApplet.parseInt(actual.x), PApplet.parseInt(actual.y))&16777215) - 16777216;
  values[n] = map(value, 0, 16777216, 0, 1000);
  set(PApplet.parseInt(actual.x), PApplet.parseInt(actual.y), value);
  
  counter++;
  }
  
  
}
// Curva de Hilbert. Transforma un int "i" en un PVector (con cordenadas x, y)
public PVector hilbert(int i) {
  
  
  PVector[] points = {
    new PVector(0, 0),
    new PVector(0, 1),
    new PVector(1, 1),
    new PVector(1, 0)
  };
  PVector point = points[i&3];
  
  int m = i>>2;
  for (int j = 1; j < order; j++) {
    
    float len = pow(2, j);
    if((m&3) == 0) {
      float temp = point.x;
      point.x = point.y;
      point.y = temp;
    } else if((m&3) == 1) {
      point.y += len;
    } else if((m&3) == 2) {
      point.x += len;
      point.y += len;
    } else if((m&3) == 3) {
      float temp = len-1-point.x;
      point.x = len-1-point.y;
      point.y = temp;
      point.x += len;
    }
    m = m >> 2;
    
  }
  
  return point;
  
  
}
// Cargar los píxeles en la imágen "image"
public void loadImageValues() {
  loadPixels();
  img.loadPixels();
  image.loadPixels();
  
  for (int i = 0; i < pixels.length; i++) {
    image.pixels[i] = pixels[i];
    pixels[i] = ((16777215-pixels[i])&16777215) - 16777216;
  }
  
  image.updatePixels();
  img.updatePixels();
  updatePixels();
}
// Guarda los datos de values en JSONvalues, e inmediatamente después los guarda en data.json 
public void saveData() {
    
  saveJSONObject(JSONvalues, "../../../data.json_A_Sonido/data.json");
  println("Valores guardados en data.json");
  
  sound.loop();
  println("Sonido cargado correctamente");
  
  float max;
  if (img.width > img.height) {
    max = img.height;
  } else {
    max = img.width;
  }
  float mult = 1024 / max;
  
  background(0);
  image(img, height2, height2, img.width*mult, img.height*mult);
  
  println("Programa completado");
  noLoop();
  return;
    
}
  public void settings() {  size(1024, 1024); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ImageToSound" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
