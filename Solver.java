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
	String message = "Solving for velocity...\n\n0 As a function of displacement and time\n1 As a function of displacement and acceleration\n";
	int category = selectCategory(message, 1);

	if (category == 0) {
	    Double d = getInput("displacement in m = ");
	    Double t = getInput("time in s = ");
	    return "\nvelocity = " + (d/t) + " m/s";
	}
	else {
	    Double d = getInput("displacement in m = ");
	    Double a = getInput("acceleration in m/s^2 = ");
	    return "\nvelocity = " + Math.sqrt(2*a*d) + " m/s";
	}
    }

    public static String m02() {
	System.out.println("\033c");
	String message = "Solving for acceleration...\n\n0 As a function of velocity and time\n1 As a function of velocity and displacement\n";
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
