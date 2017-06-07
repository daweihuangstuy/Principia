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
      dX = 1;
      tCurrent += tmax/300;
    } else if (tCurrent > tmax) {
      delay(1000);
      tCurrent = 0;
    } else {
      dX += 1/a/v;
      posX += dX;
      tCurrent += tmax/300;
    }

    ellipse(posX, posY, 5, 5);
    textSize(15);
    text("t = " + String.format("%.2f", tCurrent), 400, 450);
    text("v = " + String.format("%.2f", v + a*tCurrent), 400, 480);
    text("d = " + String.format("%.2f", v*tCurrent+0.5*a*tCurrent*tCurrent), 400, 510);
    
  } else if (typeProblem.equals("Spring Force")) {
    //
  } else if (typeProblem.equals("Centripetal Force")) {
    //
  } else if (typeProblem.equals("Elastic Collision")) {
    //
  } else if (typeProblem.equals("Inelastic Collision")) {
    //
  } else if (typeProblem.equals("Fluid Velocity")) {
    //
  } else if (typeProblem.equals("Linear Expansion")) {
    //
  } else if (typeProblem.equals("Volume Expansion")) {
    //
  } else if (typeProblem.equals("Electric Force")) {
    //
  } else if (typeProblem.equals("Magnetic Force")) {
    //
  } else if (typeProblem.equals("Refraction Index")) {
    //
  } else if (typeProblem.equals("Decay")) {
    //
  }
}