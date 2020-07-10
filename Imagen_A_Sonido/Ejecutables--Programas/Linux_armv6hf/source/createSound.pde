// Cargar los valores, convertirlos a audio y tocar el audio indefinidamente hasta que se cierre el programa
void createSound() {
  
  int counter = 0;
  while (counter < int(map(constrain(mouseX, 0, width), 0, width, 1, resolution/128))) {
    if (soundIndex >= resolution) {
      println("Valores guardados en RAM");
      task = 2;
      return;
    }
    
    float value = 0;
    for (int j = 0; j < nodes; j++) {
      value += values[j]*sin(soundIndex*map(j, 0, nodes, 27.5, 4186)*TAU/resolution);
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
