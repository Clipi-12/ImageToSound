import processing.sound.*;

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
int nodes = int(pow(pow(2, order), 2));
int n = -1;

float[] values = new float[nodes];
JSONObject JSONvalues;

AudioSample sound;
int soundIndex = 0;

float height2;
float height5;
int resolution20;



void setup() {
  size(1024, 1024);
  
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
  sound = new AudioSample(this, resolution, false, int(27.5*resolution));
  
  height2 = height/2;
  height5 = height/5;
  resolution20 = int(resolution/20);
  
  strokeWeight(1);
  background(0);
  image(img, height2, height2, img.width*mult, img.height*mult);
  loadImageValues();
}


void draw() {
  
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
