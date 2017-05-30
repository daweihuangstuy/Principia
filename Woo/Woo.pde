int state = 0;

void setup() {
  size(800, 800);
  background(0);
  textSize(40);
}

void draw() {
  if (state == 0) {
    text("Principia Physics Visualizer and Solver\nPress any key to continue.", 20, 20, 800, 800);
  }
}    