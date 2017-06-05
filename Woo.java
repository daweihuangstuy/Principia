import cs1.Keyboard;

public class Woo {

    public static final Catalog treeTopics = new Catalog();

    public static void main(String[] args){

	// start setup
        System.out.println("\033c");
	System.out.println("Welcome to Principia Physics Visualizer and Solver\nPlease type start to continue.\n");
	String startCMD = cs1.Keyboard.readString();
	while(!startCMD.equals("start")){
	    System.out.println("Please retype 'start' to continue\n");
            startCMD = cs1.Keyboard.readString();
	}
	
	while (true) { 
		    
	    int category0 = -1;
	    int category1 = -1;
	    
	    while (category1 != 9) {
	        category0 = getTopic(treeTopics.getTree().getRoot());
                category1 = getSubTopic(treeTopics.getTree().getRoot().getChildren().get(category0));
     	    }

            String methodCode = "" + category0 + "" + category1;
            System.out.println(Solver.solve(methodCode));
	    System.out.println("0 Back to Topics\n1 End\n");
	    int toContinue = cs1.Keyboard.readInt();
	    while (toContinue != 0 || toContinue != 1) {
	        System.out.println("Input error, please try again");
                toContinue = cs1.Keyboard.readInt();
	    }
	    if (toContinue == 1) {
	        return;	
	    }
	}
    }

    public static int getTopic(TopicNode parent) {
	System.out.println("\033c");
	System.out.println("What type of problem would you like to solve?");
	System.out.println(parent.listChildren() + "\n");
	int retInt = cs1.Keyboard.readInt();
	while (retInt < 0 || retInt > 9) {
	    System.out.println("\033c");
	    System.out.println("Input error, please try again");
	    System.out.println(parent.listChildren() + "\n");
	    retInt = cs1.Keyboard.readInt();
	}
	return retInt;	
    }

    public static int getSubTopic(TopicNode parent) {
	System.out.println("\033c");
        System.out.println("What would you like to solve for?");
        System.out.println(parent.listChildren());
	System.out.println("9 Go Back\n");
	int retInt = cs1.Keyboard.readInt();
        while (!(retInt >= 0 && retInt < parent.getChildren().size()) && retInt != 9) {
            System.out.println("\033c");
            System.out.println("Input error, please try again");
            System.out.println(parent.listChildren());
            retInt = cs1.Keyboard.readInt();
        }
	return retInt;
    }

}
