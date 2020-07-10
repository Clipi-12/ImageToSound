//Coge el valor de un pixel x, y mediante la curva de Hilbert
void getValues() {
  
  
  int counter = 0;
  while (counter < int(map(constrain(mouseX, 0, width), 0, width, 1, nodes/128))) {
  if (n+1 < nodes) {
    n++;
  } else {
    task = 1;
    break;
  }
  
  PVector actual = hilbert(n);
  int value = (image.get(int(actual.x), int(actual.y))&16777215) - 16777216;
  values[n] = map(value, 0, 16777216, 0, 1000);
  set(int(actual.x), int(actual.y), value);
  
  counter++;
  }
  
  
}
