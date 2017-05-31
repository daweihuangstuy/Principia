int state = 0;
int x = 300;
int y = 500;

void setup() {
  size(800, 800);
  background(0);
  textSize(40);
  textAlign(CENTER);
  textSize(40);
  text("Principia Physics Visualizer and Solver", 0 , 50, 800, 800);
  textSize(20);
  text("By Chester Huang and Dawei Huang", 0 , 120, 800, 800);
  shapeMode(CENTER);    
  fill(255,0,0,63);
  rect(x,y, 210,40);
}

void draw() {
  display();
}    

void move(){
}

void display() {
  setup();
  x -= 1;
  y += 1;
  rect(x,y, 210,40);
}
void mainMenu() {
  background(255);
  fill(0, 102, 153);
  textAlign(CENTER);
  text("word", 10, 60);
}