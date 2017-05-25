import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Motion{


    // subCat 1
    public static double[] strToDoubleArr(String[] list){
	double[] returnArr = new double[list.size];
	for(int i = 0; i < list.size; i++){
	    returnArr[i] = Integer.parseInt(list[i]);
	}
	return returnArr;
    }
    public static double unDisp1(double acc, double time, double intVel){
	return (time * intVel + 0.5 * acc * time * time); 
    }

    public static void main(String[] args){
	String input;
	// interface
	System.out.println("\nMotion");
	System.out.println("\n1. Displacement(1)/Time(2)/Acceleration(3)/InitVelocity(4)");
	
	// option
	String choiceCMD = cs1.Keyboard.readString();
	while(!choiceCMD.equals("1")){
	    choiceCMD = cs1.Keyboard.readString();
	}

	// selection
	if (choiceCMD.equals("1")){
	    System.out.println("Choose unknown(1, 2, 3)");
	    String unknownCMD = cs1.Keyboard.readString();
	    while(!unknownCMD.equals("1") ||!unknownCMD.equals("2") ||!unknownCMD.equals("3") ){
		unknownCMD = cs1.Keyboard.readString();
	    }
	    // unknown category 1
	    if (unknownCMD.equals("1")){
		System.out.println("\nInput Time_Acceleration_InitVelocity in that order");
		input = cs1.Keyboard.readString();
		String[]  = input.split("\\s+");
		System.out.println(unDisp1(
		
		 
				  
	    }
	}	
    }
}
