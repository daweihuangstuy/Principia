String mode = "starts";

void imageSetup(){
  PImage img;
  img = loadImage("bg.jpg");
  imageMode(CENTER);
  image(img, 400, 750, width/10, height/16);
}

void setup(){
  size(800, 800);
  background(0);
  textSize(40);
  textAlign(CENTER);
  textSize(40);
  text("Principia Physics Visualizer and Solver", 0 , 50, 800, 800);
  textSize(20);
  text("By Chester Huang and Dawei Huang", 0 , 120, 800, 800);
  shapeMode(CENTER);   
  frameRate(100);   //it moves 60 frames per second. Pretty fast
  textAlign(LEFT);
  exit1();
  imageSetup();
}


double dx = .5; //makes the box change direction in a specific angle. 
double dy = 1; //makes the box change direction in a specific angle. 

double x = 75;  //makes the box appear.
double y = 75;   //makes the box appear. 

void draw(){
    if (mode.equals("starts")){
      starts();
    }
    if (mode.equals("setup")){
      setup();
      menu();
    }
    if (mode.equals("menu")){
      menu();
    }
    mode();
}

void starts(){
  fill(255);
  textAlign(CENTER);
  textSize(90);
  text("CLICK ANYWHERE TO START", 0 , 300, 800, 800);
}

void ballBounce(){
  fill(255); //the color of the box (white).
    rect((float)x,(float)y,25,25,5); //makes the box a square and sets its size.

    x = x + dx; //it shows the x location of the box and moves it by 3 to each frame, causing the box to move. 
    y = y + dy; // Same as above^ but shows the Y
    
    if ( x< 0 || x > 775){  // this is the collision detection. Whenever the box hits the of the board it bounces off. 
       dx = -1 * dx; //this directs the collision to -1 also making the ball bounce. 
    }
    
    if ( y < 0 || y > 775){ //causes the ball to detect the edge of the board in the y direction.It causes it to bounce. 
       dy = -1 * dy;  //directs the collision. 
    }
}

void menu(){
  mode = "menu";
  //color buttons
  fill(57,193,37); rect(75, 200, 250, 50, 10); fill(237,149,81); rect(475, 200, 250, 50, 10);
  fill(245,57,73); rect(75, 300, 250, 50, 10); fill(144,2,188); rect(475, 300, 250, 50, 10);
  fill(137,196,55); rect(75, 400, 250, 50, 10); fill(92,98,237); rect(475, 400, 250, 50, 10);
  fill(201,77,150); rect(75, 500, 250, 50, 10); fill(91,171,47); rect(475, 500, 250, 50, 10);
  fill(79,206,167); rect(75, 600, 250, 50, 10); fill(230,237,43); rect(475, 600, 250, 50, 10);
  
  //text
  fill(255);
  text("Topic 1", 85 , 213, 800, 800); text("Topic 6", 485 , 213, 800, 800);
  text("Topic 2", 85 , 313, 800, 800); text("Topic 7", 485 , 313, 800, 800);
  text("Topic 3", 85 , 413, 800, 800); text("Topic 8", 485 , 413, 800, 800);
  text("Topic 4", 85 , 513, 800, 800); text("Topic 9", 485 , 513, 800, 800);
  text("Topic 5", 85 , 613, 800, 800); text("Topic 10", 485 , 613, 800, 800);
  
}

void mousePressed(){
  if (mode.equals("starts")){
    mode = "setup";
  }
  if (mode.equals("menu")){
    //topic 1
    if (mouseX >= 75 && mouseX <= 325 && 
      mouseY >= 200 && mouseY <= 250) {
        mode = "topic1";
      }
      
    //topic 2
    if (mouseX >= 75 && mouseX <= 325 && 
      mouseY >= 300 && mouseY <= 350) {
        mode = "topic2";
      }
      
    //topic 3
    if (mouseX >= 75 && mouseX <= 325 && 
      mouseY >= 400 && mouseY <= 450) {
        mode = "topic3";
      }
      
    //topic 4
    if (mouseX >= 75 && mouseX <= 325 && 
      mouseY >= 500 && mouseY <= 550) {
        mode = "topic4";
      }
      
    //topic 5
    if (mouseX >= 75 && mouseX <= 325 && 
      mouseY >= 600 && mouseY <= 650) {
        mode = "topic5";
      }
    //topic 6
    if (mouseX >= 475 && mouseX <= 725 && 
      mouseY >= 200 && mouseY <= 250) {
        mode = "topic6";
      }
      
    //topic 7
    if (mouseX >= 475 && mouseX <= 725 && 
      mouseY >= 300 && mouseY <= 350) {
        mode = "topic7";
      }
      
    //topic 8
    if (mouseX >= 475 && mouseX <= 725 && 
      mouseY >= 400 && mouseY <= 450) {
        mode = "topic8";
      }
      
    //topic 9
    if (mouseX >= 475 && mouseX <= 725 && 
      mouseY >= 500 && mouseY <= 550) {
        mode = "topic9";
      }
      
    //topic 10
    if (mouseX >= 475 && mouseX <= 725 && 
      mouseY >= 600 && mouseY <= 650) {
        mode = "topic10";
      }
  }
//TOPIC return
    if (mode.equals("topic1") || mode.equals("topic2") || mode.equals("topic3") || mode.equals("topic4") || mode.equals("topic5")
     || mode.equals("topic6") || mode.equals("topic7") || mode.equals("topic8") || mode.equals("topic9") || mode.equals("topic10")){
      if (mouseX >= 25 && mouseX <= 225 && 
          mouseY >= 725 && mouseY <= 775) {
            mode = "setup";
          }    
    }
    if (mouseX >= 575 && mouseX <= 775 && 
          mouseY >= 725 && mouseY <= 775) {
            exit();
          }
}

void mode(){
  if (mode.equals("topic1")){
    topic1();
  }
  if (mode.equals("topic2")){
    topic2();
  }
  if (mode.equals("topic3")){
    topic3();
  }
  if (mode.equals("topic4")){
    topic4();
  }
  if (mode.equals("topic5")){
    topic5();
  }
  if (mode.equals("topic6")){
    topic6();
  }
  if (mode.equals("topic7")){
    topic7();
  }
  if (mode.equals("topic8")){
    topic8();
  }
  if (mode.equals("topic9")){
    topic9();
  }
  if (mode.equals("topic10")){
    topic10();
  }
}

// topics ///////////////////////////////////////////////////////////////////////////
void topic1(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 1", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic2(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 2", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic3(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 3", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic4(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 4", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic5(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 5", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic6(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 6", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic7(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 7", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic8(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 8", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic9(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 9", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

void topic10(){
  setup();
  fill(255);
  textAlign(CENTER);
  textSize(30);
  text("TOPIC 10", 0 , 675, 800, 800);
  
  
  return1(); //return option to main menu
  exit1(); //exit option
}

// topics ///////////////////////////////////////////////////////////////////////////

void return1(){
  fill(245,7,7);
  rect(25, 725, 200, 50, 10);
  fill(255);
  textAlign(LEFT);
  textSize(30);
  text("RETURN", 65 , 733, 800, 800);
  fill(255);
  
}

void exit1(){
  fill(245,7,7);
  rect(575, 725, 200, 50, 10);
  fill(255);
  textAlign(LEFT);
  textSize(30);
  text("EXIT", 615 , 733, 800, 800);
  fill(255);
}