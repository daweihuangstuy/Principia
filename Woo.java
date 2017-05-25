import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import cs1.Keyboard;

public class Woo{

    public static void main(String[] args){

	// start setup
	System.out.println("Welcome to Principia Physics Visualizer and Solver\nPlease type start to continue.");
	String startCMD = cs1.Keyboard.readString();
	while(!startCMD.equals("start")){
	    System.out.println("Please retype start to continue");
	    startCMD = cs1.Keyboard.readString();
	}

	//pick category
	System.out.println("Please pick a topic using the 2 character index");

        Catalog treeTopics = new Catalog();
	System.out.println(treeTopics);

        
        /*
        int[] testArr = new int[7];
        testArr[0] = 1;
        Unit testUnit = new Unit(testArr);
        Vector test1 = new Vector(3, 4, 0, testUnit);
        System.out.println(test1);
        System.out.println(Physics.dotProduct(test1, test1));
        */
    }
}
