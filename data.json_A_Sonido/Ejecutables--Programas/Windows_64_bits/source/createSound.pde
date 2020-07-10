// Cargar los valores de data.json, convertirlos a audio y tocar el audio indefinidamente hasta que se cierre el programa
void createSound() {
  
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
