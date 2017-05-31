import java.lang.reflect.*;

public final class Solver {

    public static String solveUnknown(Double[] inputs, String typeProblem) {
        Object o = new Object();
        try {
            Method m = Solver.class.getDeclaredMethod(typeProblem, Double[].class);
            o = m.invoke(null, (Object)inputs);              
        }
        catch (NoSuchMethodException x) {
        }
        catch (IllegalAccessException x) {
        }
        catch (InvocationTargetException x) {
        }
        return "" + o;
    }

    // d = xf - xi
    public static String M00(Double[] input) {
        if (input[0] == null) {
            return input[1] - input[2] + " m";
        }
        else if (input[1] == null) {
            return input[0] + input[2] + " m";
        }
        else {
            return input[1] - input[0] + " m";
        }
    }

    // vav = d / dt
    public static String M01(Double[] input) {
        if (input[0] == null) {
            return input[1] / input[2] + " m/s";
        }
        else if (input[1] == null) {
            return input[0] * input[2] + " m";
        }
        else {
            return input[1] / input[0] + " s";
        }
    }

    // aav = dv / dt
    public static String M02(Double[] input) {
        if (input[0] == null) {
            return input[1] / input[2] + " m/s^2";
        }
        else if (input[1] == null) {
            return input[0] * input[2] + " m/s";
        }
        else {
            return input[1] / input[0] + " s";
        }
    }

    // vf = vi + (a)(t)
    public static String M03(Double[] input) {
        if (input[0] == null) {
            return input[1] + input[2] * input[3] + " m/s";
        }
        else if (input[1] == null) {
            return input[0] - input[2] * input[3] + " m/s";
        }
        else if (input[2] == null) {
            return (input[0] - input[1]) / input[3] + " m/s^2";
        }
        else {
            return (input[0] - input[1]) / input[2] + " s";
        }
    }

    // vav = (1/2)(vi + vf)
    public static String M04(Double[] input) {
        if (input[0] == null) {
            return 1/2 * (input[1] + input[2]) + " m/s";
        }
        else if (input[1] == null) {
            return 2 * input[0] - input[2] + " m/s";
        }
        else {
            return 2 * input[0] - input[1] + " m/s";
        }
    }

    // xf = xi + (1/2)(vi + vf)(t)
    public static String M05(Double[] input) {
        if (input[0] == null) {
            return input[1] + 1/2 * (input[2] + input[3]) * input[4] + " m";
        }
        else if (input[1] == null) {
            return input[0] - 1/2 * (input[2] + input[3]) * input[4] + " m";
        }
        else if (input[2] == null) {
            return (input[0] - input[1]) * 2 / input[4] - input[3] + " m/s";
        }
        else if (input[3] == null) {
            return (input[0] - input[1]) * 2 / input[4] - input[2] + " m/s";
        }
        else {
            return (input[0] - input[1]) * 2 / (input[2] + input[3]) + " m/s";
        }
    }
    

    public static void main(String[] args) {
        Double[] d = {1.0, null, 2.0};
        System.out.println(solveUnknown(d, "M1"));
    }


}
