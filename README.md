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
### Table of Contents
1) Kinematics
	1. Displacement (f(velocity,time), f(velocity,time,acceleration))
	2. Velocity (f(displacment,time), f(velocity,displacment,acceleration))
	3. Acceleration (f(velocity,time), f(velocity,displacment))
2) Forces
	1. Weight
		1. On Earth (f(weight))
		2. Given Acceleration of Gravity (f(mass, gravitational acceleration))
	2. Spring
		1. Spring force (f(displacement, spring constant))
	3. Friction
		1. Static Friction (f(normal force, static coefficient))
		2. Kinetic Friction (f(normal force, kinetic coefficient))
	4. Centripetal
		1. Force (f(mass, Cent. accleration))
		2. Force (f(mass, velocity, radius))
3) Energy and Power
	1. Work
		1. Some force (f(force, displacement, angle))
		2. Spring force (f(displacement, spring constant))
	2. Kinetic Energy
		1. Kinetic Energy (f(mass, velocity))
		2. Kinetic Energy (f(mass, momentum))
	3. Potential Energy
		1. Earth Gravity (f(mass, height))
	4. Torque
		1. Torque (f(force, angle, radius))
	5. Power
		1. Power (f(work, time))
		2. Power (f(force, velocity))
4) Momentum
	1. Linear Momentum (f(mass, velocity))
	2. Angular Momentum (f(mass, velocity, radius))
	3. Collisions
		1. elastic collision (f(mass of objects, int vel of obj1))
		2. perfect inelastic collision (f(mass of obj1, mass of obj2, vel of obj1))
5) Sound Waves
	1. Velocity (f(frequency, wavlength), f(tension, mass per length))
	2. Sound Intensity (f(power, area), f(decibels))
	3. Doppler Effect
		1. Moving Observer (f(vel Observer, speed of wave, source frequency))
		2. Moving Source (f(vel Source, speed of wave, source frequency))
		3. General Case (f(vel Source, vel Observer, speed of wave, source frequency, percieved frequency))
	4. Beat Frequency
		1. Interfering Frequencies (f(frequency1, frequency2))
6) Fluids
	1. Density
	2. Pressure
	3. Fluid Exit Speed
7) Temperature and Heat
	1. Electrostatics
	2. Magnetism
	3. Currents
8) Electromagnetism
	1. Electrostatics
	2. Magnetism
	3. Currents
9) Light and Optics
	1. Electromagnetic Spectrum
	2. Refraction
	3. Diffraction
10) Quantum and Nuclear
	1. Relativity
	2. Photons