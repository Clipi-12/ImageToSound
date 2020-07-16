// Cargar los píxeles en la imagen "image"
void loadImageValues() {
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
