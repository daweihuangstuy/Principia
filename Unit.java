import java.util.*;

public class Unit{

    // indices represent length, mass, time, electric current,
    // thermodynamic temperature, amount of substance, luminous intensity

    // SI units: meter, kilogram, second, ampere, kelvin, mole, candela
    private ArrayList<Integer> unitSI = new ArrayList<Integer>(7);

    // default constructor
    public Unit(){

    }

    // overloaded constructor
    public Unit(ArrayList<Integer> newSI){
        unitSI = newSI;
    }

    // accessors
    public ArrayList<Integer> getSI(){
        return unitSI;
    }

    // mutators
    public ArrayList<Integer> setSI(ArrayList<Integer> newSI) {
        ArrayList<Integer> oldSI = unitSI;
        unitSI = newSI;
        return oldSI;
    }

    public String toString(){
        return "WIP";
    }

}
