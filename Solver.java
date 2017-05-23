public final class Solver{

    public static Vector M1(){
        System.out.println("Magnitude of displacement in meters:");
        double dispMag = cs1.Keyboard.readDouble();
        System.out.println("Time in seconds:");
        double t = cs1.Keyboard.readDouble();

        int[] unitLength = {1,0,0,0,0,0,0};
        Vector displacement = new Vector(dispMag, new Unit(unitLength));
        int[] unitTime = {0,0,1,0,0,0,0};
        Scalar time = new Scalar(t, new Unit(unitTime));

        return Physics.scaleMag(displacement, Physics.reciprocal(time));
    }

}
