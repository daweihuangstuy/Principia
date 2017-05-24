import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Motion{


    // subCat 1
    public static int unDisp1(int acc, int time, int intVel){
	return (time * 
    }

    public static void main(String[] args){
	// interface
	System.out.println("\n1. Displacement(1)/Time(2)/Acceleration(3)/InitVelocity(4)");

	// option
	choiceCMD = cs1.Keyboard.readString();
	while(!choiceCMD.equals("1")){
	    choiceCMD = cs1.Keyboard.readString();
	}

	// selection
	if (choiceCMD.equals("1")){
	    System.out.println("Choose unknown(1, 2, 3)");
	    unknownCMD = cs1.Keyboard.readString();
	    while(!unknownCMD.equals("1") ||!unknownCMD.equals("2") ||!unknownCMD.equals("3") ){
		unknownCMD = cs1.Keyboard.readString();
	    }
	    if(
	}
	
	
    }
}
