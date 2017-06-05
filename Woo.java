import cs1.Keyboard;

public class Woo {

    public static final 

    public static void main(String[] args){

	// start setup
        System.out.println("\033c");
	System.out.println("Welcome to Principia Physics Visualizer and Solver\nPlease type start to continue.\n");
	String startCMD = cs1.Keyboard.readString();
	while(!startCMD.equals("start")){
	    System.out.println("Please retype 'start' to continue\n");
            startCMD = cs1.Keyboard.readString();
	}

        Catalog treeTopics = new Catalog();
        TopicNode current = treeTopics.getTree().getRoot();

	int category0 = getTopic(current);
	current = current.getChildren().get(category0);     
        int category1 = getSubTopic(current);

        String methodCode = "" + category0 + "" + category1;
        System.out.println(Solver.solve(methodCode));

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
	if (retInt == 9) {
	    getTopic(
	}
	return retInt;
    }

}
