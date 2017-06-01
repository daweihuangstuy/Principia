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

}


double dx = .5; //makes the box change direction in a specific angle. 
double dy = 1; //makes the box change direction in a specific angle. 

double x = 75;  //makes the box appear.
double y = 75;   //makes the box appear. 
void draw(){
    setup();
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