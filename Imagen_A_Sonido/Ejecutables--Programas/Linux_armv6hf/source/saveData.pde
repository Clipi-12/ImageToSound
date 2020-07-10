// Guarda los datos de values en JSONvalues, e inmediatamente después los guarda en data.json 
void saveData() {
    
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
