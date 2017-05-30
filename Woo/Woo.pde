int state = 0;

void setup() {
  size(800, 800);
  background(0);
  textSize(40);
}

void draw() {
  if (state == 0) {
    textAlign(CENTER);
    textSize(40);
    text("Principia Physics Visualizer and Solver\nMain Menu", 0 , 0, 800, 800);
    textSize(20);
    text("By: Chester Huang and Dawei Huang Period 5", 0 , 100, 800, 800);
    fill(255,0,0,63);
    rect(0,150,200,40);
  }
  if (mousePressed) {
      mainMenu();
  }
  state += 1;
}    

void mainMenu() {
  background(255);
  fill(0, 102, 153);
  textAlign(CENTER);
  text("word", 10, 60);
}