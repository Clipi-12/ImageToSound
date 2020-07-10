// Curva de Hilbert. Transforma un int "i" en un PVector (con cordenadas x, y)
PVector hilbert(int i) {
  
  
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
