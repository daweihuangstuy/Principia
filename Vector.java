public class Vector{
    
    // vector components
    private double X;
    private double Y;
    private double Z;

    // magnitude and direction
    private double magnitude;
    private double thetaXY;
    private double thetaYZ;
    private double thetaZX;

    private Unit unit;

    // default constructor
    public Vector(){
        
    }

    // overloaded constructors
    public Vector(double xx, double yy, double zz, Unit u) {
        X = xx;
        Y = yy;
        Z = zz;
        magnitude = calcMag();
        thetaXY = calcXY();
        thetaYZ = calcYZ();
        thetaZX = calcZX();
        unit = u;
    }
    public Vector(double mag, Unit u){
        magnitude = mag;
        unit = u;
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
    public double getThetaZX(){
        return thetaZX;
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
    public double setThetaZX(double newThetaZX){
        double oldThetaZX = thetaZX;
        thetaZX = newThetaZX;
        return thetaZX;
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

    // calculate angle between XY axes, relative to X
    public double calcXY(){
        // quadrant 1 or 4 angle
        if (X > 0) {
            return Math.atan(Y/X);
        }
        // quadrant 2 or 3 angle
        else {
            return Math.atan(Y/X) + Math.PI;
        }
    }

    // calculate angle between YZ axes, relative to Y
    public double calcYZ(){
        // quadrant 1 or 4 angle
        if (Y > 0) {
            return Math.atan(Z/Y);
        }
        // quadrant 2 or 3 angle
        else {
            return Math.atan(Z/Y) + Math.PI;
        }    
    }

    // calculate angle between ZX axes, relative to Z
    public double calcZX(){
            // quadrant 1 or 4 angle
        if (Z > 0) {
            return Math.atan(X/Z);
        }
        // quadrant 2 or 3 angle
        else {
            return Math.atan(X/Z) + Math.PI;
        }     
    }

    public String toString(){
        return getMag() + " " +  getUnit();
    }
    
}
