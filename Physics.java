import java.util.*;

public final class Physics{

    // uninstantiable because this is a static class
    private Physics(){
    }

    // calculate dot product of two vectors
    public static double dotProduct(Vector u, Vector v){
        return u.getX()*v.getX() + u.getY()*v.getY() + u.getZ()*v.getZ();
    }

    // calculate angle in between two vectors
    public static double angleBetween(Vector u, Vector v){
        double cosTheta = dotProduct(u, v) / u.getMag() / v.getMag();
        return Math.acos(cosTheta);
    }
    
    // calculate product of vector and scalar
    public static Vector scale(Vector u, Scalar k){
        double newX = u.getX() * k.getMag();
        double newY = u.getY() * k.getMag();
        double newZ = u.getZ() * k.getMag();
        Unit newUnit = resolveUnitsSI(u.getUnit(), k.getUnit());
        return new Vector(newX, newY, newZ, newUnit);
    }

    // calculate product of variable number of units
    public static Unit resolveUnitsSI(Unit... argsSI){
        ArrayList<Integer> newSI = new ArrayList<Integer>(7);

        // loop through all arguments
        for (Unit u: argsSI) {
            // add value at index of argument to value at index of output
            for (int i = 0; i < u.getSI().size(); i++){
                newSI.set(i, newSI.get(i) + u.getSI().get(i));
            }
        }

        return new Unit(newSI);
    }
    
}
