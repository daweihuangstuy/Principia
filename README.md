# Team Principia
Chester Huang and Dawei Huang

## Physics Interpreter and Visualizer
We present a physics interpreter that can evaluate various types of user input in order to solve problems.
The user can choose from a variety topics from simple motion to electromagnetism to nuclear physics.
When applicable, there is an option to save a certain problem and the inputs provided to be later visualized.

### How It Works
There are four parts to this project:
1) Interface with navigable menu for choosing topics.
2) Solving specific problems given data input by using various functions.
3) Output of data and saving when applicable.
4) Visualization of problems.

### Launch Instructions
Clone the repository:
```
$ git clone git@github.com:daweihuangstuy/Principia.git
```
To access the physics solver, compile and run Woo.java:
```
$ javac Woo.java
$ java Woo
```

To access the visualizer, navigate to the processing directory and run:
```
$ cd Woo
$ processing Woo.pde
Click Run at the top left
```
###Table of Contents
1) Kinematics
	-Displacement (f(velocity,time),f(velocity,time,acceleration))
	-Velocity (f(displacment,time),f(velocity,displacment,acceleration))
	-Acceleration (f(velocity,time),f(velocity,displacment))
2) Forces
3) Energy and Power
4) Momentum
5) Sound Waves
6) Fluids
7) Temperature and Heat
8) Electromagnetism
9) Light and Optics
10) Quantum and Nuclear