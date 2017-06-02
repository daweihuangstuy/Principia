import java.lang.reflect.*;
import cs1.Keyboard;

public final class Solver {

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

    public static String m00() {
        System.out.println("\033c");
        String message = "Solving for displacement...\n\n0 As a function of velocity and time\n1 As a function of velocity, time, and acceleration\n";
        int category = selectCategory(message, 1);

        if (category == 0) {
            Double v = getInput("velocity in m/s = ");
            Double t = getInput("time in s = ");
            return "\ndisplacement = " + v*t + " m";
        }
        else {
            Double v = getInput("velocity in m/s = ");
            Double t = getInput("time in s = ");
            Double a = getInput("acceleration in m/s^2 = ");
            return "\ndisplacement = " + (v*t + 1.0/2*a*t*t) + " m";
        }
    }

    public static String m01() {
        System.out.println("\033c");
        String message = "Solving for velocity...\n\n0 As a function of displacement and time\n1 Given initial velocity, displacement, and acceleration\n";
        int category = selectCategory(message, 1);

        if (category == 0) {
            Double d = getInput("displacement in m = ");
            Double t = getInput("time in s = ");
            return "\nvelocity = " + (d/t) + " m/s";
        }
        else {
            Double vi = getInput("initial velocity in m/s = ");
            Double d = getInput("displacement in m = ");
            Double a = getInput("acceleration in m/s^2 = ");
            return "\nfinal velocity = " + Math.sqrt(vi*vi+2*a*d) + " m/s";
        }
    }

    public static String m02() {
        System.out.println("\033c");
        String message = "Solving for acceleration...\n\n0 As a function of change in velocity and time\n1 As a function of velocity and displacement\n";
        int category = selectCategory(message, 1);

        if (category == 0) {
            Double v = getInput("velocity in m/s = ");
            Double t = getInput("time in s = ");
            return "\nacceleration = " + (v/t) + " m/s^2";
        }
        else {
            Double vi = getInput("initial velocity in m/s = ");
            Double vf = getInput("final velocity in m/s = ");
            Double d = getInput("displacement in m = ");
            return "\nacceleration = " + (vf*vf-vi*vi)/(2*d) + " m/s^2";
        }
    }
    
    public static String m10() {
        System.out.println("\033c");
        String message = "Solving for Weight...\n\n0 On Earth\n1 Given acceleration of gravity\n";
        int category = selectCategory(message, 1);
        
        if (category == 0) {
            Double m = getInput("mass in kg = ");
            return "\nweight = " + (m*9.81) + " N";             
        }
        else {
            Double m = getInput("mass in kg = ");
            Double ag = getInput("acceleration of gravity in m/s^2 = ");
            return "\nacceleration = " + (m*ag) + " N";
        }               
    }
    
    public static String m11() {
        System.out.println("\033c");
        String message = "Solving for the force of a spring...\n\n0 Given displacement and spring constant\n";
        int category = selectCategory(message, 0);
        
        Double x = getInput("displacement in m = ");
        Double k = getInput("spring constant in N/m = ");
        return "\nforce = " + (-1*k*x) + " N";
    }
    
    public static String m12() {
        System.out.println("\033c");
        String message = "Solving for the force of friction...\n\n0 Static Friction\n1 Kinetic Friction\n";
        int category = selectCategory(message, 1);
            
        if (category == 0) {
            Double fN = getInput("normal force in N = ");
            Double MUs = getInput("coefficient of static friction = ");
            return "\nstatic friction = " + (MUs*fN) + " N";    
        }
        else {
            Double fN = getInput("normal force in N = ");
            Double MUk = getInput("coefficient of kinetic friction = ");
            return "\nkinetic friction = " + (MUk*fN) + " N";   
        }
    }
        
    public static String m13() {
        System.out.println("\033c");
        String message = "Solving for centripetal force...\n\n0 As a function of mass and centripetal acceleration\n1 As a function of mass, velocity, and radius\n";
        int category = selectCategory(message, 1);
            
        if (category == 0) {
            Double m = getInput("mass in kg = ");
            Double acp = getInput("centripetal acceleration in m/s^2 = ");
            return "\ncentripetal force = " + (m*acp) + " N";
        }
        else {
            Double m = getInput("mass in kg = ");
            Double v = getInput("velocity in m/s = ");
            Double r = getInput("radius in m = ");
            return "\ncentripetal force = " + (m*v*v/r) + " N";
        }              
    }
        
    public static String m20() {
        System.out.println("\033c");
        String message = "Solving for work done...\n\n0 By some force\n1 By a spring\n";
        int category = selectCategory(message, 1);
            
        if (category == 0) {
            Double F = getInput("force applied in N = ");
            Double d = getInput("displacement in m = ");
            Double theta = getInput("angle between force and displacement in degrees = ");
            return "work done = " + (F*d*Math.cos(theta*Math.PI/180)) + " J";
        }
        else {
            Double x = getInput("displacement in m = ");
            Double k = getInput("spring constant in N/m = ");
            return "\nwork done = " + (-1.0/2*k*x*x) + " J";            
        }
    }
    
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
    
    public static Double getInput(String message) {
        Double d = null;
        while (d == null || d.equals(Double.NaN)) {
            System.out.print(message);
            d = Keyboard.readDouble();
        }
        return d;
    }
}
