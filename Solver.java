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
        System.out.println("Solving for displacement...\n");
        System.out.println("0 As a function of velocity and time");
        System.out.println("1 As a function of velocity, time, and acceleration\n");

        int category = Keyboard.readInt();
        while (category != 0 && category != 1) {
            System.out.println("\033c");
            System.out.println("Input error, please try again\n");
            System.out.println("Solving for displacement...\n");
            System.out.println("0 As a function of velocity and time");
            System.out.println("1 As a function of velocity, time, and acceleration\n");
            category = Keyboard.readInt();
        }

        if (category == 0) {
            System.out.print("velocity in m/s = ");
            Double v = Keyboard.readDouble();
            System.out.print("time in s = ");
            Double t = Keyboard.readDouble();
            System.out.println();
            return "displacement = " + v*t + " m";
        }
        else {
            System.out.print("velocity in m/s = ");
            Double v = Keyboard.readDouble();
            System.out.print("time in s = ");
            Double t = Keyboard.readDouble();
            System.out.print("acceleration in m/s^2 = ");
            Double a = Keyboard.readDouble();
            System.out.println();
            return "displacement = " + (v*t + 1.0/2*a*t*t) + " m";
        }
    }
    
}
