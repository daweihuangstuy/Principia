String mode = "starts";
String[] lines;

/*
void imageSetup(){
 PImage img;
 img = loadImage("bg.jpg");
 imageMode(CENTER);
 image(img, 400, 750, width/10, height/16);
 }
 */

void setup() {
  lines = loadStrings("../data.txt");
  size(800, 800);
  PImage img = loadImage("bg.jpg");
  background(img);
  fill(0);
  textSize(40);
  textAlign(CENTER);
  textSize(40);
  text("Principia Physics Visualizer and Solver", 0, 50, 800, 800);
  textSize(20);
  text("By Chester Huang and Dawei Huang", 0, 120, 800, 800);
  shapeMode(CENTER);   
  frameRate(60);   //it moves 60 frames per second. Pretty fast
  textAlign(LEFT);
  exit1();
  //imageSetup();
}

void setup2() {
  size(800, 800);
  background(241, 239, 240);
  fill(0);
  textSize(40);
  textAlign(CENTER);
  textSize(40);
  text("Principia Physics Visualizer and Solver", 0, 50, 800, 800);
  textSize(20);
  text("By Chester Huang and Dawei Huang", 0, 120, 800, 800);
  shapeMode(CENTER);   
  frameRate(100);   //it moves 60 frames per second. Pretty fast
  textAlign(LEFT);
  exit1();
}


double dx = .5; //makes the box change direction in a specific angle. 
double dy = 1; //makes the box change direction in a specific angle. 

double x = 75;  //makes the box appear.
double y = 75;   //makes the box appear. 

void draw() {
  if (mode.equals("starts")) {
    starts();
  }
  if (mode.equals("setup")) {
    setup2();
    menu();
  }
  if (mode.equals("menu")) {
    menu();
  }
  mode();
}

void starts() {
  fill(0);
  textAlign(CENTER);
  textSize(28);
  text("CLICK ANYWHERE TO START", 0, 600, 800, 800);
}

void ballBounce() {
  fill(255); //the color of the box (white).
  rect((float)x, (float)y, 25, 25, 5); //makes the box a square and sets its size.

  x = x + dx; //it shows the x location of the box and moves it by 3 to each frame, causing the box to move. 
  y = y + dy; // Same as above^ but shows the Y

  if ( x< 0 || x > 775) {  // this is the collision detection. Whenever the box hits the of the board it bounces off. 
    dx = -1 * dx; //this directs the collision to -1 also making the ball bounce.
  }

  if ( y < 0 || y > 775) { //causes the ball to detect the edge of the board in the y direction.It causes it to bounce. 
    dy = -1 * dy;  //directs the collision.
  }
}

void menu() {
  mode = "menu";
  //color buttons
  fill(187, 200, 216); 
  rect(75, 200, 250, 50, 10); 
  fill(187, 200, 216); 
  rect(475, 200, 250, 50, 10);
  fill(116, 139, 167); 
  rect(75, 300, 250, 50, 10); 
  fill(116, 139, 167); 
  rect(475, 300, 250, 50, 10);
  fill(76, 104, 139); 
  rect(75, 400, 250, 50, 10); 
  fill(76, 104, 139); 
  rect(475, 400, 250, 50, 10);
  fill(20, 48, 84); 
  rect(75, 500, 250, 50, 10); 
  fill(20, 48, 84); 
  rect(475, 500, 250, 50, 10);
  fill(5, 27, 56); 
  rect(75, 600, 250, 50, 10); 
  fill(5, 27, 56); 
  rect(475, 600, 250, 50, 10);

  //text
  fill(255);
  textSize(25);
  text(lines[0].split(",")[0], 85, 213, 800, 800); 
  text(lines[5].split(",")[0], 485, 213, 800, 800);
  text(lines[1].split(",")[0], 85, 313, 800, 800); 
  text(lines[6].split(",")[0], 485, 313, 800, 800);
  text(lines[2].split(",")[0], 85, 413, 800, 800); 
  text(lines[7].split(",")[0], 485, 413, 800, 800);
  text(lines[3].split(",")[0], 85, 513, 800, 800); 
  text(lines[8].split(",")[0], 485, 513, 800, 800);
  text(lines[4].split(",")[0], 85, 613, 800, 800); 
  text(lines[9].split(",")[0], 485, 613, 800, 800);
}

void mousePressed() {
  if (mode.equals("starts")) {
    mode = "setup";
  }
  if (mode.equals("menu")) {
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
    || mode.equals("topic6") || mode.equals("topic7") || mode.equals("topic8") || mode.equals("topic9") || mode.equals("topic10")) {
    if (mouseX >= 25 && mouseX <= 225 && 
      mouseY >= 725 && mouseY <= 775) {
      mode = "setup";
      tCurrent = 0;
    }
  }
  if (mouseX >= 575 && mouseX <= 775 && 
    mouseY >= 725 && mouseY <= 775) {
    exit();
  }
}

void mode() {
  if (mode.equals("topic1")) {
    topic1();
  }
  if (mode.equals("topic2")) {
    topic2();
  }
  if (mode.equals("topic3")) {
    topic3();
  }
  if (mode.equals("topic4")) {
    topic4();
  }
  if (mode.equals("topic5")) {
    topic5();
  }
  if (mode.equals("topic6")) {
    topic6();
  }
  if (mode.equals("topic7")) {
    topic7();
  }
  if (mode.equals("topic8")) {
    topic8();
  }
  if (mode.equals("topic9")) {
    topic9();
  }
  if (mode.equals("topic10")) {
    topic10();
  }
}

// topics ///////////////////////////////////////////////////////////////////////////
void topic1() {
  if (readFile(1) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[0].split(",")[0], 0, 675, 800, 800);

  animate(1);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic2() {
  if (readFile(2) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[1].split(",")[0], 0, 675, 800, 800);

  animate(2);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic3() {
  if (readFile(3) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[2].split(",")[0], 0, 675, 800, 800);

  animate(3);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic4() {
  if (readFile(4) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[3].split(",")[0], 0, 675, 800, 800);

  animate(4);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic5() {
  if (readFile(5) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[4].split(",")[0], 0, 675, 800, 800);

  animate(5);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic6() {
  if (readFile(6) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[5].split(",")[0], 0, 675, 800, 800);

  animate(6);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic7() {
  if (readFile(7) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[6].split(",")[0], 0, 675, 800, 800);

  animate(7);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic8() {
  if (readFile(8) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[7].split(",")[0], 0, 675, 800, 800);

  animate(8);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic9() {
  if (readFile(9) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[8].split(",")[0], 0, 675, 800, 800);

  animate(9);

  return1(); //return option to main menu
  exit1(); //exit option
}

void topic10() {
  if (readFile(10) == null) {
    mode = "menu";
    return;
  }
  setup2();
  fill(0);
  textAlign(CENTER);
  textSize(30);
  text(lines[9].split(",")[0], 0, 675, 800, 800);

  animate(10);

  return1(); //return option to main menu
  exit1(); //exit option
}

// topics ///////////////////////////////////////////////////////////////////////////

String[] readFile(int order) {  
  //String[] lines = loadStrings("../data.txt"); made into global var
  if (lines[order-1].equals("")) {
    return null;
  }
  String[] targetLine = lines[order-1].split(",");
  return targetLine;
}

void return1() {
  fill(0);
  rect(25, 725, 200, 50, 10);
  fill(255);
  textAlign(LEFT);
  textSize(30);
  text("RETURN", 55, 733, 800, 800);
  fill(255);
}

void exit1() {
  fill(0);
  rect(575, 725, 200, 50, 10);
  fill(255);
  textAlign(LEFT);
  textSize(30);
  text("EXIT", 680, 733, 800, 800);
  fill(255);
}


double tCurrent = 0;
float posX = 100;
float posY = 400;
double dX;
float spacing;
float theta;

void animate(int topicNum) {
  String[] splitLine = lines[topicNum-1].split(",");
  String typeProblem = splitLine[0];

  if (typeProblem.equals("Displacement")) {
    double v = Double.parseDouble(splitLine[1]);
    double tmax = Double.parseDouble(splitLine[2]);
    double a = Double.parseDouble(splitLine[3]);

    if (tCurrent == 0) {
      posX = 150;
      posY = 400;
      dX = .5;
      tCurrent += tmax/300;
    } else if (tCurrent > tmax) {
      delay(1000);
      tCurrent = 0;
    } else {
      dX += 2/a/v;
      posX += dX;
      tCurrent += tmax/300;
    }

    ellipse(posX, posY, 5, 5);
    textSize(15);
    text("t = " + String.format("%.2f", tCurrent) + " s", 400, 450);
    text("v = " + String.format("%.2f", v + a*tCurrent) + " m/s", 400, 480);
    text("d = " + String.format("%.2f", v*tCurrent+0.5*a*tCurrent*tCurrent) + " m", 400, 510);
  } else if (typeProblem.equals("Spring Force")) {
    Double x = Double.parseDouble(splitLine[1]);
    Double k = Double.parseDouble(splitLine[2]);

    if (tCurrent == 0) {
      posX = 150;
      posY = 400;
      spacing = 4;
      tCurrent += 1.0/60;
    } else if (tCurrent > 4) {
      delay(3000);
      tCurrent = 0;
    } else {
      spacing += .01*x/Math.abs(x);
      tCurrent += 1.0/60;
    }

    fill(255);
    for (int i = 0; i<75; i++) {
      ellipse(posX+i*spacing, posY, 10, 50);
    }

    fill(0);
    textSize(15);
    if (x > 0) {
      arrow(640, 450, 550, 450);
      text("F = " + String.format("%.2f", -1*k*x) + " N", 600, 500);

      arrow(550, 350, 640, 350);
      text("d = " + String.format("%.2f", k) + " m", 600, 320);
    } else if (x <0) {
      arrow(160, 450, 250, 450);
      text("F = " + String.format("%.2f", -1*k*x) + " N", 200, 500);

      arrow(250, 350, 160, 350);
      text("d = " + String.format("%.2f", k) + " m", 200, 320);
    }
  } else if (typeProblem.equals("Static Friction")) {
    Double fn = Double.parseDouble(splitLine[1]);
    Double us = Double.parseDouble(splitLine[2]);

    fill(255);
    triangle(100, 600, 100, 300, 600, 600);
    quad(250, 390, 400, 480, 430, 430, 280, 340);
    arrow(265, 365, 165, 305);
    arrow(355, 385, 385, 335);

    fill(0);
    textSize(15);
    text("Fs = " + String.format("%.2f", fn*us) + " N", 100, 280);
    text("FN = " + String.format("%.2f", fn) + " N", 385, 315);
  } else if (typeProblem.equals("Centripetal Force")) {
    Double m = Double.parseDouble(splitLine[1]);
    Double v = Double.parseDouble(splitLine[2]);
    Double r = Double.parseDouble(splitLine[2]); 

    if (tCurrent == 0) {
      posX = 400;
      posY = 400;
      tCurrent += 1.0/60;
      theta = 0;
    } else if (tCurrent > 5) {
      tCurrent = 0;
    } else {
      posX = 400+ 100*cos(theta);
      posY = 400+ 100*sin(theta);
      theta += 2*Math.PI/300;
    }
    fill(255);
    ellipse(400, 400, 200, 200);
    fill(0);
    ellipse(posX, posY, 5, 5);
    arrow((float)posX, (float)posY, 
      (float)(400+100*Math.sqrt(2)*cos((float)(theta+Math.PI/4))), (float)(400+100*Math.sqrt(2)*sin((float)(theta+Math.PI/4))));
    arrow((float)posX, (float)posY, 400, 400);

    fill(0);
    textSize(15);
    text("v = " + String.format("%.2f", v) + " m/s", (float)(400+100*Math.sqrt(2)*cos((float)(theta+Math.PI/4))), (float)(400+100*Math.sqrt(2)*sin((float)(theta+Math.PI/4))));
    text("r = " + String.format("%.2f", r) + " m", 400, 600);
    text("F = " + String.format("%.2f", m*v*v/r) + " N", 400, 400);
  } else if (typeProblem.equals("Elastic Collision")) {
    Double m1 = Double.parseDouble(splitLine[1]);
    Double m2 = Double.parseDouble(splitLine[1]);
    Double v1 = Double.parseDouble(splitLine[2]); 

    if (tCurrent == 0) {
      posX = 50;
      posY = 400;
      tCurrent += 1.0/60;
    } else if (tCurrent > 6) {
      tCurrent = 0;
    } else if (tCurrent > 3) {
      tCurrent += 1.0/60;
      fill(255);
      rect(230, 400, 150, 80);
      rect(150+posX, 400, 150, 80);
      posX += 1;
      fill(0);
      textSize(15);  
      text(String.format("%.2f", m1) + " kg", 305, 440);
      text(String.format("%.2f", m2) + " kg", 225+posX, 440);
      text("v = " + String.format("%.2f", v1*m1/m2) + " m/s", posX+225, 500);
    } else {
      tCurrent += 1.0/60;
      posX += 1;
      fill(255);
      rect(posX, 400, 150, 80);
      rect(380, 400, 150, 80);
      fill(0);
      textSize(15);  
      text(String.format("%.2f", m1) + " kg", posX+75, 440);
      text("v = " + String.format("%.2f", v1) + " m/s", posX+75, 500);
      text(String.format("%.2f", m2) + " kg", 455, 440);
    }
  } else if (typeProblem.equals("Fluid Velocity")) {
    Double h = Double.parseDouble(splitLine[1]);
    fill(255);
    ellipse(400, 300, 100, 40);
    ellipse(400, 500, 100, 40);
    line(350, 300, 350, 500);
    line(450, 300, 450, 500);
    rect(445, 420, 5, 5);
    arrow(445, 420, 500, 550);

    fill(0);
    textSize(15);  
    text("h = " +String.format("%.2f", h) + " m", 500, 400);
    text("v = " +String.format("%.2f", Math.sqrt(2*9.81*h)) + " m/s", 560, 520);
  } else if (typeProblem.equals("Linear Expansion")) {
    Double a1 = Double.parseDouble(splitLine[1]);
    Double b1 = Double.parseDouble(splitLine[2]);
    Double c1 = Double.parseDouble(splitLine[3]);

    float lengthScale = (float)((a1 + a1*b1*c1) / 600);
    if (lengthScale < 10){
      lengthScale = 10;
    }
    
    fill(0);
    rect(100,400, 400 , 10);
    fill(0);
    textSize(15);
    text("initial length = " + String.format("%.2f", b1), 175, 425);
    
      
    if (tCurrent == 0){
      posX = 0;
      fill(42,131,41);
      rect(500,400, posX , 10);
      tCurrent += 1.0/60;
    }
    if (tCurrent > 0){
      fill(42,131,41);
      rect(500, 400, posX , 10);
      tCurrent += 1.0/60;
      posX += .25;
      fill(0);
      textSize(15);
      text("kelvin = " + String.format("%.2f", c1), posX + 500 , 370);
      text("length = " + String.format("%.2f", b1 * posX / 400), posX + 500 , 350);
      text("kelvin = " + String.format("%.2f", c1), 175, 445);
      text("length = " + String.format("%.2f", b1 * posX / 400), 175, 465);
    } 
    if (posX == a1*b1*c1/b1 * 400){
       tCurrent = 0;
       delay(5000);
    }
  } else if (typeProblem.equals("Volume Expansion")) {
    //
    Double a1 = Double.parseDouble(splitLine[1]); //coefficient
    Double b1 = Double.parseDouble(splitLine[2]); //int volume
    Double c1 = Double.parseDouble(splitLine[3]); //delta temperature
    
    float scaleVolume = (float)((b1 + a1*b1*c1) / b1);
    float volRatio = (posX + 100)*(posX + 100) / 10000;
    
    rectMode(RADIUS);
    
    if(tCurrent == 0){
      posX = 0;
      fill(52,255,243);
      rect(400, 400, 100, 100);
      fill(0);
      rect(400, 400, 100, 100);
      tCurrent += 1.0 / 60;
    }
    if(tCurrent > 0){
      posX += .1;
      fill(52,255,243);
      rect(400, 400, 100 + posX, 100 + posX);
      fill(0);
      rect(400, 400, 100, 100);
      tCurrent += 1.0 / 60;
      textSize(15);
      volRatio = (posX + 100)*(posX + 100) / 10000;
      text("current volume = " + String.format("%.2f", volRatio * b1), 100, 665);
      text("initial volume = " + String.format("%.2f", b1), 100, 645);
    }
    if((100 + posX) * (100 + posX) > scaleVolume * 10000){
      fill(0);
      rect(400, 400, 100, 100);
      tCurrent = 0;
      delay(5000);
    }

    
    
    
    rectMode(CORNER);
  } else if (typeProblem.equals("Electric Force")) {
    Double q1 = Double.parseDouble(splitLine[1]);
    Double q2 = Double.parseDouble(splitLine[2]);
    Double r = Double.parseDouble(splitLine[3]); 

    fill(0);
    textSize(15);  
    ellipse(250, 400, 5, 5);
    ellipse(550, 400, 5, 5);
    line(250, 400, 550, 400);    

    fill(0);
    text("q1 = " + String.format("%6.2e", q1) + " C", 220, 440);
    text("q2 = " + String.format("%6.2e", q2) + " C", 580, 440);
    text("r = " + String.format("%6.2e", r) + " m", 400, 415);

    if (q1*q2 > 0) {
      text("F = " + String.format("%6.2e", Math.abs(q1*q2*8.99E9/r/r)) + " N", 400, 360);
      arrow(300, 352, 200, 352);
      arrow(500, 352, 600, 352);
    } else {
      text("F = " + String.format("%6.2e", Math.abs(q1*q2*8.99E9/r/r)) + " N", 400, 360);
      arrow(200, 352, 300, 352);
      arrow(600, 352, 500, 352);
    }
  } else if (typeProblem.equals("Refraction Index")) {
    double n1 = Double.parseDouble(splitLine[1]);
    double theta1 = Double.parseDouble(splitLine[2]);
    double theta2 = Double.parseDouble(splitLine[3]); 

    fill(255);
    stroke(0);
    rect(300, 350, 200, 100);
    line(340, 250, 340, 450);
    line(340+100*tan((float)(theta2*Math.PI/180)), 350, 340+100*tan((float)(theta2*Math.PI/180)), 550);
    stroke(255, 204, 0);
    line(340, 350, (340-100*tan((float)(theta1*Math.PI/180))), 250);
    line(340, 350, 340+100*tan((float)(theta2*Math.PI/180)), 450);   
    line(340+100*tan((float)(theta2*Math.PI/180)), 450, (340+100*tan((float)(theta1*Math.PI/180))), 550);
    stroke(0);

    fill(0);
    textSize(15);  
    text("n1 = " + n1, 340, 230);
    text("n2 = " + String.format("%.4f", n1*Math.sin(theta2*(Math.PI/180))/Math.sin(theta1*Math.PI/180)), 440, 405);
  } else if (typeProblem.equals("Decay")) {
    //
  }
}

void arrow(float x1, float y1, float x2, float y2) {
  line(x1, y1, x2, y2);
  pushMatrix();
  translate(x2, y2);
  float a = atan2(x1-x2, y2-y1);
  rotate(a);
  line(0, 0, -10, -10);
  line(0, 0, 10, -10);
  popMatrix();
} 