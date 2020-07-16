import processing.sound.*;

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



void setup() {
  size(512, 512);
    
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
  //sound = new AudioSample(this, resolution, false, int(27.5*resolution));
  sound = new AudioSample(this, resolution, false, int(27.5*resolution));
  resolution128 = resolution/128;
  
  background(0);

}

void draw() {
  createSound();
}
