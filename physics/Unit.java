public class Unit{

    // indices represent length, mass, time, electric current,
    // thermodynamic temperature, amount of substance, luminous intensity

    // SI units: meter, kilogram, second, ampere, kelvin, mole, candela
    private int[] unitSI = new int[7];

    // default constructor
    public Unit(){

    }

    // overloaded constructor
    public Unit(int[] newSI){
        unitSI = newSI;
    }

    // accessors
    public int[] getSI(){
        return unitSI;
    }

    // mutators
    public int[] setSI(int[] newSI){
        int[] oldSI = unitSI;
        unitSI = newSI;
        return oldSI;
    }

    public Unit reciprocal(){
        int[] newUnitArr = new int[7];
        for (int i = 0; i < unitSI.length; i++){
            newUnitArr[i] = -1 * unitSI[i];
        }
        return new Unit(newUnitArr);
    }
    
    public String toString(){
        String retStr = "";
        for (int i = 0; i < unitSI.length; i++){
            if (unitSI[i] == 0){
            }
            else {
                String exponent;
                if (unitSI[i] == 1) {
                    exponent = "";
                }
                else {
                    exponent = "^" + unitSI[i];
                }

                switch(i){                              
                    case 0: retStr += "m" + exponent + " ";
                            break;
                    case 1: retStr += "kg" + exponent + " ";
                            break;
                    case 2: retStr += "s" + exponent + " ";
                            break;
                }
            }
        }
        return retStr;
    }

}
