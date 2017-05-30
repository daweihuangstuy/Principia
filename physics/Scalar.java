public class Scalar{

    private double magnitude;
    private Unit unit;

    // default construtor
    public Scalar(){

    }

    // overloaded constructor
    public Scalar(double m, Unit u){
        magnitude = m;
        unit = u;
    }     
    
    // accessors    
    public double getMag(){
        return magnitude;
    }
    public Unit getUnit(){
        return unit;
    }

    // mutators
    public double setMag(double newMag){
        double oldMag = magnitude;
        magnitude = newMag;
        return oldMag;
    }
    public Unit setUnit(Unit newUnit){
        Unit oldUnit = unit;
        unit = newUnit;
        return oldUnit;
    }
    
    public String toString(){
        return getMag() + " " + getUnit();
    }
    
}
