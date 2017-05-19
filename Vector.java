public class Vector{
    // vector components
    private double X;
    private double Y;
    private double Z;

    // magnitude and direction
    private double magnitude;
    private double thetaXY;
    private double thetaYZ;

    private Unit unit;

    // default constructor
    public Vector(){
        
    }

    // accessors
    public double getX(){
        return X;
    }
    public double getY(){
        return Y;
    }
    public double getZ(){
        return Z;
    }
    public double getMag(){
        return magnitude;
    }
    public double getThetaXY(){
        return thetaXY;
    }
    public double getThetaYZ(){
        return thetaYZ;
    }
    public Unit getUnit(){
        return unit;
    }

    // mutators
    public double setX(double newX){
        double oldX = X;
        X = newX;
        return oldX;
    }
    public double setY(double newY){
        double oldY = Y;
        Y = newY;
        return oldY;
    }
    public double setZ(double newZ){
        double oldZ = Z;
        Z = newZ;
        return oldZ;
    }
    public double setMag(double newMag){
        double oldMag = magnitude;
        magnitude = newMag;
        return magnitude;
    }
    public double setThetaXY(double newThetaXY){
        double oldThetaXY = thetaXY;
        thetaXY = newThetaXY;
        return thetaXY;
    }
    public double setThetaYZ(double newThetaYZ){
        double oldThetaYZ = thetaYZ;
        thetaYZ = newThetaYZ;
        return thetaYZ;
    }
    public Unit setUnit(Unit newUnit){
        Unit oldUnit = unit;
        unit = newUnit;
        return unit;
    }

    // calculate magnitude
    public double calcMag(){
        // magnitude in 2-space
        double magXY = Math.sqrt(X*X + Y*Y);
        // magnitude in 3-space
        double magXYZ = Math.sqrt(magXY*magXY + Z*Z);
        return magXYZ;  
    }

    public Vector cross(Vector u, Vector v) {
        return u;
    }

    public double dotProduct(Vector u, Vector v) {
        return 0;
    }
}
