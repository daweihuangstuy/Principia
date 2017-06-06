import java.lang.reflect.*;
import java.io.*;
import cs1.Keyboard;

public class Solver {

    public static String[] arrData = {"", "", "", "", "", "", "", "", "", ""};
    
    // call the method with name associated with a String
    public static String solve(String methodCode) {
        Object o = new Object();
        try {
            Method m = Solver.class.getMethod("m" + methodCode);
            o = m.invoke(null);              
        }
        catch (NoSuchMethodException x) {
        }
        catch (IllegalAccessException x) {
        }
        catch (InvocationTargetException x) {
        }
        return "" + o;
    }
    
    // Motion, Displacement
    public static void m00() {
        System.out.println("\033c");
        String message = "Solving for displacement...\n\n0 As a function of velocity and time\n1 As a function of velocity, time, and acceleration\n";
        int category = selectCategory(message, 1);

        // d = v/t
        if (category == 0) {
            Double v = getInput("velocity in m/s = ");
            Double t = getInput("time in s = ");
            System.out.println("\ndisplacement = " + String.format("%.4f", v*t) + " m");
        }
        // d = vt + 0.5at^2
        else {
            Double v = getInput("velocity in m/s = ");
            Double t = getInput("time in s = ");
            Double a = getInput("acceleration in m/s^2 = ");
            System.out.println("\ndisplacement = " + String.format("%.4f", v*t + 1.0/2*a*t*t) + " m");
	    addData("Displacement", v, t, a);
        }
    }

    // Motion, Velocity
    public static void m01() {
        System.out.println("\033c");
        String message = "Solving for velocity...\n\n0 As a function of displacement and time\n1 Given initial velocity, displacement, and acceleration\n";
        int category = selectCategory(message, 1);

        // v = d /t
        if (category == 0) {
            Double d = getInput("displacement in m = ");
            Double t = getInput("time in s = ");
            System.out.println("\nvelocity = " + String.format("%.4f", d/t) + " m/s");
        }
        // v = (vi^2+2ad)^(1/2)
        else {
            Double vi = getInput("initial velocity in m/s = ");
            Double d = getInput("displacement in m = ");
            Double a = getInput("acceleration in m/s^2 = ");
            System.out.println("\nfinal velocity = " + String.format("%.4f", Math.sqrt(vi*vi+2*a*d)) + " m/s");
        }
    }

    // Motion, Acceleration
    public static void m02() {
        System.out.println("\033c");
        String message = "Solving for acceleration...\n\n0 As a function of change in velocity and time\n1 As a function of velocity and displacement\n";
        int category = selectCategory(message, 1);

        // a = v/t
        if (category == 0) {
            Double v = getInput("velocity in m/s = ");
            Double t = getInput("time in s = ");
            System.out.println("\nacceleration = " + String.format("%.4f", v/t) + " m/s^2");
        }
        // a = (vf^2-vi^2)/(2d)
        else {
            Double vi = getInput("initial velocity in m/s = ");
            Double vf = getInput("final velocity in m/s = ");
            Double d = getInput("displacement in m = ");
            System.out.println("\nacceleration = " + String.format("%.4f", vf*vf-vi*vi/(2*d)) + " m/s^2");
        }
    }

    // Forces, Weight
    public static void m10() {
        System.out.println("\033c");
        String message = "Solving for Weight...\n\n0 On Earth\n1 Given acceleration of gravity\n";
        int category = selectCategory(message, 1);

        // W = mg
        if (category == 0) {
            Double m = getInput("mass in kg = ");
            System.out.println("\nweight = " + String.format("%.4f", (m*9.81)) + " N");             
        }
        // F = m*ag
        else {
            Double m = getInput("mass in kg = ");
            Double ag = getInput("acceleration of gravity in m/s^2 = ");
            System.out.println("\nacceleration = " + String.format("%.4f", (m*ag)) + " N");
        }               
    }

    // Forces, Spring
    public static void m11() {
        System.out.println("\033c");
        String message = "Solving for the force of a spring...\n\n0 Given displacement and spring constant\n";
        int category = selectCategory(message, 0);

        // F = -kx
        Double x = getInput("displacement in m = ");
        Double k = getInput("spring constant in N/m = ");
        System.out.println("\nforce = " + String.format("%.4f", -1*k*x) + " N");
	addData("Spring Force", x, k);
    }

    // Forces, Friction
    public static void m12() {
        System.out.println("\033c");
        String message = "Solving for the force of friction...\n\n0 Static Friction\n1 Kinetic Friction\n";
        int category = selectCategory(message, 1);

        // F = usFn
        if (category == 0) {
            Double fN = getInput("normal force in N = ");
            Double MUs = getInput("coefficient of static friction = ");
            System.out.println("\nstatic friction = " + String.format("%.4f", MUs*fN) + " N");
	    addData("Static Friction", fN, MUs);
        }
        // F = ukFn
        else {
            Double fN = getInput("normal force in N = ");
            Double MUk = getInput("coefficient of kinetic friction = ");
            System.out.println("\nkinetic friction = " + String.format("%.4f", MUk*fN) + " N");   
        }
    }

    // Forces, Centripetal
    public static void m13() {
        System.out.println("\033c");
        String message = "Solving for centripetal force...\n\n0 As a function of mass and centripetal acceleration\n1 As a function of mass, velocity, and radius\n";
        int category = selectCategory(message, 1);

        // F = ma
        if (category == 0) {
            Double m = getInput("mass in kg = ");
            Double acp = getInput("centripetal acceleration in m/s^2 = ");
            System.out.println("\ncentripetal force = " + String.format("%.4f", m*acp) + " N");
        }
        // F = mv^2/r
        else {
            Double m = getInput("mass in kg = ");
            Double v = getInput("velocity in m/s = ");
            Double r = getInput("radius in m = ");
            System.out.println("\ncentripetal force = " + String.format("%.4f", m*v*v/r) + " N");
	    addData("Centripetal Force", m, v, r);
        }              
    }

    // Work, By a Force
    public static void m20() {
        System.out.println("\033c");
        String message = "Solving for work done...\n\n0 By some force\n1 By a spring\n";
        int category = selectCategory(message, 1);

        // W = Fd*cos(theta)
        if (category == 0) {
            Double F = getInput("force applied in N = ");
            Double d = getInput("displacement in m = ");
            Double theta = getInput("angle between force and displacement in degrees = ");
            System.out.println("work done = " + String.format("%.4f", F*d*Math.cos(theta*Math.PI/180)) + " J");
        }
        // W = -1/2kx^2
        else {
            Double x = getInput("displacement in m = ");
            Double k = getInput("spring constant in N/m = ");
            System.out.println("\nwork done = " + String.format("%.4f", -1.0/2*k*x*x) + " J");            
        }
    }

    // Energy, Kinetic
    public static void m21() {
        System.out.println("\033c");
        String message = "Solving for kinetic energy...\n\n0 As a function of mass and velocity\n1 As a function of mass and momentum\n";
        int category = selectCategory(message, 1);

        // K = 1/2mv^2
        if (category == 0) {
            Double m = getInput("mass in kg = ");
            Double v = getInput("velocity in m/s = ");
            System.out.println("\nkinetic energy = " + String.format("%.4f", 1.0/2*m*v*v) + " J");
        }
        // K = p^2/(2m)
        else {
            Double m = getInput("mass in kg = ");
            Double p = getInput("momentum in kg*m/s = ");
            System.out.println("\nkinetic energy = " + String.format("%.4f",p*p/2/m) + " J");
        }
    }

    // Energy, Potential
    public static void m22() {
        System.out.println("\033c");
        String message = "Solving for potential energy...\n\n0 By gravity on earth\n";
        int category = selectCategory(message, 0);

        // U = mgh
        Double m = getInput("mass in kg = ");
        Double h = getInput("height in m = ");
        System.out.println("potential energy = " + String.format("%.4f", m*9.81*h) + " J");
    }

    // Work, Torque
    public static void m23() {
        System.out.println("\033c");
        String message = "Solving for torque...\n\n0 Given force at an angle and radius\n";
        int category = selectCategory(message, 0);

        // T = Fr*sin(theta)
        Double F = getInput("force in N = ");
        Double theta = getInput("angle in degrees = ");
        Double r = getInput("radius in m = ");    
            
        System.out.println("torque = " + String.format("%.4f", F*r*Math.sin(theta*Math.PI/180)) + " N*m");
    }

    // Power, Power
    public static void m24() {
        System.out.println("\033c");
        String message = "Solving for power...\n\n0 As a function of work and time\n1 As a function of force and velocity\n";
        int category = selectCategory(message, 1);

        // P = W/t
        if (category == 0) {
            Double W = getInput("work in J = ");
            Double t = getInput("time in s = ");
            System.out.println("power = " + String.format("%.4f", W/t) + " W");
        }
        // P = Fv
        else {
            Double F = getInput("force in N = ");
            Double v = getInput("velocity in m/s = ");
            System.out.println("power = " + String.format("%.4f", F*v) + " W");
        }
    }

    // Momentum, Linear
    public static void m30() {        
        System.out.println("\033c");
        String message = "Solving for linear momentum...\n\n0 Given mass and velocity\n";
        int category = selectCategory(message, 0);

        // p = mv
        Double m = getInput("mass in kg = ");
        Double v = getInput("velocity in m/s = ");
        System.out.println("momentum = " + String.format("%.4f", m*v) + " kg*m/s");
    }

    // Momentum, Angular
    public static void m31() {
        System.out.println("\033c");
        String message = "Solving for angular momentum...\n\n0 Given mass, velocity, and radius of rotation\n";
        int category = selectCategory(message, 0);

        // L = mvr
        Double m = getInput("mass in kg = ");
        Double v = getInput("velocity in m/s = ");
        Double r = getInput("radius in m = ");
        System.out.println("momentum = " + String.format("%.4f", m*v*r) + " J*s");
    }

    // Momentum, Collisions
    public static void m32() {
        System.out.println("\033c");
        String message = "Solving for final velocity...\n\n0 In an elastic collision\n1 In a perfectly inelastic collision\n";
        int category = selectCategory(message, 1);

        // vf = 2va*ma/(ma+mb)
        if (category == 0) {
            Double ma = getInput("mass of first object in kg = ");
            Double mb = getInput("mass of second object in kg = ");
            Double via = getInput("mass of initial velocity of first object in m/s = ");
            System.out.println("final velocity of second object = " + String.format("%.4f", 2*via*ma/(ma+mb)) + " m/s");
        }
        // vf = (ma*va + mb*vb)/(ma+mb)
        else {
            Double ma = getInput("mass of first object in kg = ");
            Double mb = getInput("mass of second object in kg = ");
            Double via = getInput("initial velocity of first object in m/s = ");
            Double vib = getInput("initial velocity of second object in m/s = ");
            System.out.println("final velocity = " + String.format("%.4f", (ma*via + mb*vib)/(ma+mb)) + " m/s");    
        } 
    }

    // Waves, Velocity
    public static void m40() {
        System.out.println("\033c");
        String message = "Solving for velocity of a wave...\n\n0 Given frequency and wavelength\n1 Given tension and mass per length\n";
        int category = selectCategory(message, 1);
        
        // v = lambda*f
        if (category == 0) {
            Double lambda = getInput("wavelength in m = ");
            Double f = getInput("frequency in Hz = ");
            System.out.println("velocity = " + String.format("%.4f", (lambda*f)) + " m/s");
        }
        // v = (F/u)^(1/2)
        else {
            Double F = getInput("tension force in N = ");
            Double mu = getInput("mass per length in kg/m ");
            System.out.println("velocity = " + String.format("%.4f", (Math.sqrt(F/mu))) + " m/s");
        }
    }

    // Waves, Intensity
    public static void m41() {
        System.out.println("\033c");
        String message = "Solving for sound intensity...\n\n0 Given power and area\n1 In decibels\n";
        int category = selectCategory(message, 1);

        // I = P/A
        if (category == 0) {
            Double P = getInput("power in J/s = ");
            Double A = getInput("area in m^2 = ");
            System.out.println("intensity = " + String.format("%.4f", P/A) + " W/m^2");
        }
        // B = 10log(I/I0)
        else {
            Double P = getInput("power in J/s = ");
            Double A = getInput("area in m^2 = ");
            System.out.println("decibels = " + String.format("%.4f", 10*Math.log10(P/A/(1E-12))) + " dB");
        }
    }

    // Waves, Doppler Effect
    public static void m42() {
        System.out.println("\033c");
        String message = "Solving for perceived frequency...\n\n0 Moving Observer\n1 Moving Source\n2 General Case\n";
        int category = selectCategory(message, 2);
        
        // f = (1 + u/v)f0
        if (category == 0) {
            Double u = getInput("velocity of observer towards source in m/s = ");
            Double v = getInput("speed of waves in m/s = ");
            Double f0 = getInput("frequency of source in Hz = ");
            System.out.println("perceived frequency = " + String.format("%.4f", (1 + u/v)*f0) + " Hz");
        }
        // f = f0/(1 + u/v)
        else if (category == 1) {
            Double u = getInput("velocity of source towards observer in m/s = ");
            Double v = getInput("speed of waves in m/s = ");
            Double f0 = getInput("frequency of source in Hz = ");
            System.out.println("perceived frequency = " + String.format("%.4f", f0/(1 + u/v)) + " Hz");
        }
        // f = (1 + uo/v)/(1 + us/v)*f0
        else {
            Double uo = getInput("velocity of observer towards source in m/s = ");
            Double us = getInput("velocity of source towards observer in m/s = ");
            Double v = getInput("speed of waves in m/s = ");
            Double f0 = getInput("frequency of source in Hz = ");
            System.out.println("perceived frequency = " + String.format("%.4f", (1 + uo/v)/(1 + us/v)*f0) + " Hz");
        }
    }

    // Waves, Beat Frequency
    public static void m43() {
        System.out.println("\033c");
        String message = "Solving for beat frequency...\n\n0 Of interfering frequencies\n";
        int category = selectCategory(message, 0);
        
        // f = |f1 - f2|
        Double f1 = getInput("frequency1 in Hz = ");
        Double f2 = getInput("frequency2 in Hz = ");
        System.out.println("beat frequency = " + String.format("%.4f", Math.abs(f1 - f2)) + " Hz");
    }

    // Fluids, Density
    public static void m50() {
        System.out.println("\033c");
        String message = "Solving for density of a fluid...\n\n0 Given mass and volume\n";
        int category = selectCategory(message, 0);
        
        // p = m/V
        Double m = getInput("mass of fluid in kg = ");
        Double V = getInput("volume of fluid in m^3 = ");
        System.out.println("density = " + String.format("%.4f", m/V) + " kg/m^3");
    }

    // Fluids, Pressure
    public static void m51() {
        System.out.println("\033c");
        String message = "Solving for pressure...\n\n0 Given force and area\n1 Gauge pressure\n2 Fluid at some depth\n";
        int category = selectCategory(message, 2);
        
        // P = F/A
        if (category == 0) {
            Double F = getInput("force in N = ");
            Double A = getInput("area in m^2 = ");
            System.out.println("pressure = " + String.format("%.4f", F/A) + " Pa");
        }
        // Pg = P - Pat
        else if (category == 1) {
            Double P = getInput("actual pressure in Pa = ");
            System.out.println("gauge pressure = " + String.format("%.4f", P - 1.01E5) + " Pa");
        }
        // P2 = P1 + pgh
        else {
            Double P1 = getInput("pressure at one point in Pa = ");
            Double p = getInput("density of fluid in kg/m^3 = ");
            Double h = getInput("depth below point in m = ");
            System.out.println("pressure = " + String.format("%.4f", P1 + p*9.81*h) + " Pa");
        }
    } 
    
    // Fluids, Exit Speed
    public static void m52() {
        System.out.println("\033c");
        String message = "Solving for fluid exit speed...\n\n0 Given height of exit point\n";
        int category = selectCategory(message, 0);
        
        // v = (2gh)^(1/2)
        Double h = getInput("height in m = ");
        System.out.println("speed = " + String.format("%.4f", Math.sqrt(2*9.81*h)) + " m/s");
    }

    // Temperature and Heat, Expansion
    public static void m60() {
        System.out.println("\033c");
        String message = "Solving for thermal expansion...\n\n0 Linear\n1 Volume\n";
        int category = selectCategory(message, 1);
        
        // dL = aLT
        if (category == 0) {
            Double a = getInput("coefficient of linear expansion in K^-1 = ");
            Double L = getInput("initial length in m = ");
            Double T = getInput("change in temperature in K = ");
            System.out.println("linear expansion = " + String.format("%.4f", a*L*T) + " m");
        }
        // dV = BVT
        else {
            Double B = getInput("coefficient of volume expansion in K^-1 = ");
            Double V = getInput("initial volume in m = ");
            Double T = getInput("change in temperature in K = ");
            System.out.println("volume expansion = " + String.format("%.4f", B*V*T) + " m");
        }
    }

    // Temperature and Heat, Specific Heat
    public static void m61() {
        System.out.println("\033c");
        String message = "Solving for specific heat...\n\n0 Given mass and heat capacity\n1 Given mass, heat, change in temperature\n";
        int category = selectCategory(message, 1);
        
        // c = C/m
        if (category == 0) {
            Double m = getInput("mass in kg = ");
            Double C = getInput("heat capacity in J/K = ");
            System.out.println("specific heat = " + String.format("%.4f", C/m) + " J/(kg K)");
        }
        // c = Q/m/T
        else {
            Double m = getInput("mass in kg = ");
            Double Q = getInput("added heat J = ");
            Double T = getInput("change in temperature in K = ");
            System.out.println("specific heat = " + String.format("%.4f", Q/m/T) + " J/(kg K)");
        }
    }

    // Temperature and Heat, Conduction
    public static void m62() {
        System.out.println("\033c");
        String message = "Solving for heat exchanged...\n\n0 Given conductivity, area, temperature difference, length, and time\n";
        int category = selectCategory(message, 0);

        // Q = kA(dT/L)t
        Double k = getInput("thermal conductivity in W/(m*K) = ");
        Double A = getInput("cross sectional area in m^2 = ");
        Double T = getInput("temperature difference in K = ");
        Double L = getInput("length in m = ");
        Double t = getInput("time in s = ");
        System.out.println("heat exchanged = " + String.format("%.4f", k*A*T*t/L) + " J");
    }

    // Electromagnetism, Electrostatics
    public static void m70() {
        System.out.println("\033c");
        String message = "Solving for electrical quantities...\n\n0 Electrostatic force\n1 Electric field\n2 Electric flux\n3 Electric potential\n";
        int category = selectCategory(message, 3);

        Double k = 8.99E9;
        
        // F = kq1q2/r^2
        if (category == 0) {
            Double q1 = getInput("first point charge in C = ");
            Double q2 = getInput("second point charge in C = ");
            Double r = getInput("distance between points in m = ");
            System.out.println("electrostatic force = " + String.format("%.4f", k*q1*q2/r/r) + " N");
        }
        // E = kq/r^2
        else if (category == 1) {
            Double q = getInput("point charge in C = ");
            Double r = getInput("distance from charge in m = ");
            System.out.println("electric field = " + String.format("%.4f", k*q/r/r) + " N/C");
        }
        // flux = EAcos(theta)
        else if (category == 2) {
            Double E = getInput("electric field in N/C = ");
            Double A = getInput("cross sectional area in m^2 = ");
            Double theta = getInput("angle between electric field and cross section in degrees = ");
            System.out.println("electric flux = " + String.format("%.4f", E*A*Math.cos(theta*Math.PI/180)) + " N/C");     
        }
        // V = kq/r
        else {
            Double q = getInput("point charge in C = ");
            Double r = getInput("distance from charge in m = ");
            System.out.println("electric potential = " + String.format("%.4f", k*q/r) + " V");
        }
    }

    // Electromagnetism, Magnetism
    public static void m71() {
        System.out.println("\033c");
        String message = "Solving for quantities of magnetism...\n\n0 Magnetic force\n1 Radius of motion of charged particle\n2 Force on a wire\n3 Torque on a current loop\n4 Magnetic field from a current loop\n5 Magnetic flux\n";
        int category = selectCategory(message, 5);
        
        // F = |q|vBsin(theta)
        if (category == 0) {
            Double q = getInput("charge of particle in C = ");
            Double v = getInput("velocity of particle in m/s = ");
            Double B = getInput("magnitude of magnetic field in T");
            Double theta = getInput("angle between velocity and magnetic field in degrees = ");
            System.out.println("magnetic force = " + String.format("%.4f", Math.abs(q)*v*B*Math.sin(theta*Math.PI/180)) + " N");
        }
        // r = mv/|q|B
        else if (category == 1) {
            Double m = getInput("mass of particle in kg = ");
            Double v = getInput("velocity of particle in m/s = ");
            Double q = getInput("charge of particle in C = ");
            Double B = getInput("magnetic field in T = ");
            System.out.println("radius = " + String.format("%.4f", m*v/Math.abs(q)/B) + " m");
        }
        // F = ILBsin(theta)
        else if (category == 2) {
            Double I = getInput("current in wire in A = ");
            Double L = getInput("length of wire in m ");
            Double B = getInput("magnetic field in T = ");
            Double theta = getInput("angle between wire and magnetic field in degrees = ");
            System.out.println("force on wire = " + String.format("%.4f", I*L*B*Math.sin(theta*Math.PI/180)) + " N");
        }
        // T = NIABsin(theta)
        else if (category == 3) {
            Double N = getInput("number of loops in wire = ");
            Double I = getInput("current in wire in A = ");
            Double A = getInput("area of the loop in m^2 = ");
            Double B = getInput("magnetic field in T = ");
            Double theta = getInput("angle between wire and magnetic force in degrees = ");
            System.out.println("torque = " + String.format("%.4f", N*I*A*B*Math.sin(theta*Math.PI/180)) + " N*m");
        }
        // B = NuI/(2R)
        else if (category == 4) {
            Double N = getInput("number of loops in wire = ");
            Double I = getInput("current in wire in A = ");
            Double R = getInput("radius of loop in m = ");
            System.out.println("magnetic field = " + String.format("%.4f", N*8.85E-12*I/2/R) + " T");
        }
        // flux = BAcos(theta)
        else {
            Double B = getInput("magnetic field in T = ");
            Double A = getInput("cross sectional area in m^2 = ");
            Double theta = getInput("angle between magnetic field and cross section in degrees = ");
            System.out.println("magnetic flux = " + String.format("%.4f", B*A*Math.cos(theta*Math.PI/180)) + " Wb");
        }
    }

    // Electromagnetism, Currents
    public static void m72() {
        System.out.println("\033c");
        String message = "Solving systems of currents...\n\n0 Voltage\n1 Resistance\n2 Power\n";
        int category = selectCategory(message, 2);
        
        // V = IR
        if (category == 0) {
            Double I = getInput("current in A = ");
            Double R = getInput("resistance in ohms = ");
            System.out.println("voltage = " + String.format("%.4f", I*R) + " V");
        }
        // R = rhoL/A
        else if (category == 1) {
            Double rho = getInput("resistivity in ohm*m = ");
            Double L = getInput("length of wire in m = ");
            Double A = getInput("cross sectional area in m^2 = ");
            System.out.println("resistance = " + String.format("%.4f", rho*L/A) + " ohms");
        }
        // P = IV
        else {
            Double I = getInput("current in A = ");
            Double V = getInput("voltage in V = ");
            System.out.println("power = " + String.format("%.4f", I*V) + " W");
        }
    }

    // Light, Electromagnetic Spectrum
    public static void m80() {
        System.out.println("\033c");
        String message = "Solving for properties of light...\n\n0 Frequency\n1 Momentum transferred\n2 Transmitted intensity\n";
        int category = selectCategory(message, 2);
        
        // f = c/lambda
        if (category == 0) {
            Double lambda = getInput("wavelength of light in m = ");
            System.out.println("frequency = " + String.format("%.4f", 3E8/lambda) + " Hz");
        }
        // p = U/c
        else if (category == 1) {
            Double U = getInput("energy delivered in J = ");
            System.out.println("momentum transferred = " + String.format("%.4f", U/3E8) + " kg*m/s"); 
        }
        // I = I0(cos theta)^2
        else {
            Double I0 = getInput("initial intensity in W/m^2 = ");
            Double theta = getInput("angle between transmission axis and polarizer in degrees = ");
            System.out.println("transmitted intensity = " + String.format("%.4f", I0*Math.pow(Math.cos(theta*Math.PI/180), 2)) + " W/m^2");
        }
    }

    // Optics, Refraction
    public static void m81() {
        System.out.println("\033c");
        String message = "Solving for index of refraction...\n\n0 Given speed in medium\n1 Given angles of refraction\n";
        int category = selectCategory(message, 1);
        
        // n = c/v
        if (category == 0) {
            Double v = getInput("velocity in medium in m/s = ");
            System.out.println("index of refraction = " + String.format("%.4f", 3E8/v) + "");
        }
        // n1 = n2sin(02)/sin(01)
        else {
            Double n2 = getInput("index of refraction of first medium = ");
            Double theta2 = getInput("angle of refraction in first medium in degrees = ");
            Double theta1 = getInput("angle of refraction in second medium in degrees = ");
            System.out.println("index of refraction of second medium = " + String.format("%.4f", n2*Math.sin(theta2*(Math.PI/180))/Math.sin(theta1*Math.PI/180)) + "");
        }
    }

    // Optics, Diffraction
    public static void m82() {
        System.out.println("\033c");
        String message = "Solving for angle for bright fringes...\n\n0 In a double-slit diffraction\n";
        int category = selectCategory(message, 0);
        
        // theta = arcsin(lambda/d)
        Double lambda = getInput("wavelength of light in m = ");
        Double d = getInput("separation of slits in m = ");
        System.out.println("angle = " + String.format("%.4f", Math.asin(lambda/d)) + "");
    }

    // Quantum and Nuclear, Relativity
    public static void m90() {
        System.out.println("\033c");
        String message = "Solving for relativistic quantities...\n\n0 Time dilation\n1 Length contraction\n";
        int category = selectCategory(message, 1);

        Double c = 3E8;
        
        // dt = t0/(sqrt(1 - v^2/c^2))
        if (category == 0) {
            Double t0 = getInput("proper time in s = ");
            Double v = getInput("speed relative to observer in m/s = ");
            System.out.println("dilated time measure = " + String.format("%.4f", t0/Math.sqrt(1-v*v/c/c)) + " s");
        }
        // L = L0(sqrt(1-v^2/c^2))
        else {
            Double L0 = getInput("proper length in m = ");
            Double v = getInput("speed relative to observer in m/s = ");
            System.out.println("contracted length = " + String.format("%.4f", L0*Math.sqrt(1-v*v/c/c)) + "");
        }
    }

    // Photons
    public static void m91() {
        System.out.println("\033c");
        String message = "Solving for frequency of photon...\n\n0 Given energy\n1 Cutoff frequency\n2 Given momentum\n";
        int category = selectCategory(message, 2);

        Double h = 6.63E-34;
        
        // f = E/h
        if (category == 0) {
            Double E = getInput("energy of photon in J = ");
            System.out.println("frequency = " + String.format("%.4f", E/h) + " Hz");
        }
        // f0 = W0/h
        else if (category == 1) {
            Double W0 = getInput("work function in J = ");
            System.out.println("cutoff frequency = " + String.format("%.4f", W0/h) + " Hz");
        }
        // f = pc/h
        else {
            Double p = getInput("momentum of photon in kg*m/s = ");
            System.out.println("frequency = " + String.format("%.4f", p*3E8/h) + " Hz");
        }
    }

    // Radioactivity
    public static void m92() {
        System.out.println("\033c");
        String message = "Solving for radioactive nuclei...\n\n0 Quantity as a function of time\n1 Decay rate\n";
        int category = selectCategory(message, 1);
        
        // N = N0e^(-lambda t)
        if (category == 0) {
            Double N0 = getInput("initial number of radioactive nuclei = ");
            Double lambda = getInput("decay constant in s^-1 = ");
            Double t = getInput("time in s = ");
            System.out.println("nuclei remaining = " + String.format("%.4f", N0*Math.pow(Math.E, (-1*lambda*t))) + "");
        }
        // R = lambda*N
        else {
            Double lambda = getInput("decay constant in s^-1 = ");
            Double N = getInput("number of nuclei = ");
            System.out.println("decay constant = " + String.format("%.4f", lambda*N) + " nuclei/s");
        }
    }



    
    // template for declaring solve methods
    public static void m() {
        System.out.println("\033c");
        String message = "";
        int category = selectCategory(message, 1);
        
        //
        if (category == 0) {
            System.out.println("" + String.format("%.4f", 0.0) + "");
        }
        //
        else {
            System.out.println("" + String.format("%.4f", 0.0) + "");
        }
    }



    
    // used for selecting various equations under a topics
    public static int selectCategory(String message, int maxChoice) {
        System.out.println(message);
        int category = Keyboard.readInt();
        while (category == Integer.MIN_VALUE ||
               category < 0 || category > maxChoice) {
            System.out.println("Error reading data, please retry.");
            category = Keyboard.readInt();
        }
        return category;
    }

    // getting a valid Double input
    public static Double getInput(String message) {
        Double d = null;
        while (d == null || d.equals(Double.NaN)) {
            System.out.print(message);
            d = Keyboard.readDouble();
        }
        return d;
    }
    
    // add to arrData
    public static void addData(String problemCode, Double... inputs) {

	System.out.println("\nWould you like to save this problem for visualization?\n\n0 Yes\n1 No\n");
	int choice = cs1.Keyboard.readInt();
	while (choice != 0 && choice != 1) {
	    System.out.println("Input error, please try again.");
	    choice = cs1.Keyboard.readInt();
	}
	
	if (choice == 1) {
	    System.out.println("\033c");
	    return;
	}

        String newEntry = problemCode + ",";
        for (Double d : inputs) {
            newEntry += d + ",";
        }
        newEntry += "\r\n";

        // add to empty slot if possible
        for (int i = 0; i < 10; i++) {
            if (arrData[i].equals("")) {
                arrData[i] = newEntry;
                write();
		System.out.println("\033c\nData is saved");
                return;
            }
        }
        
        // otherwise, shift everything left, add to last position
        for (int i = 0; i < 9; i++) {
            arrData[i] = arrData[i+1];
        }
        arrData[9] = newEntry;
        write();
        
	System.out.println("\n\033cData is saved");
    }
    
    // writing to txt file
    public static void write() {
        BufferedWriter writer = null;
        try {
            File savedData = new File("data.txt");
            writer = new BufferedWriter(new FileWriter(savedData));

            // arrData global variable with saved inputs
            for (String s : arrData) {
                writer.write(s);
            }
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
