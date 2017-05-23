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

    public static Vector scaleMag(Vector u, Scalar k){
        double newMag = u.getMag() * k.getMag();
        Unit newUnit = resolveUnitsSI(u.getUnit(), k.getUnit());
        return new Vector(newMag, newUnit);
    }
    
    // calculate product of variable number of units
    public static Unit resolveUnitsSI(Unit... argsSI){
        int[] newSI = new int[7];

        // loop through all arguments
        for (Unit u: argsSI) {
            // add value at index of argument to value at index of output
            for (int i = 0; i < u.getSI().length; i++){
                newSI[i] += u.getSI()[i];
            }
        }

        return new Unit(newSI);
    }

    public static Scalar reciprocal(Scalar s){
        double newMag = 1 / s.getMag();
        Unit newUnit = s.getUnit().reciprocal();
        Scalar newScalar = new Scalar(newMag, newUnit);
        return newScalar;
    }
    
}