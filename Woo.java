import cs1.Keyboard;

public class Woo {

    public static void main(String[] args){

	// start setup
        System.out.println("\033c");
	System.out.println("Welcome to Principia Physics Visualizer and Solver\nPlease type start to continue.\n");
	String startCMD = cs1.Keyboard.readString();
	while(!startCMD.equals("start")){
	    System.out.println("Please retype 'start' to continue\n");
            startCMD = cs1.Keyboard.readString();
	}

        //pick category
        System.out.println("\033c");
	System.out.println("What type of problem would you like to solve?");

        Catalog treeTopics = new Catalog();
        TopicNode current = treeTopics.getTree().getRoot();
	System.out.println(current.listChildren() + "\n");

        int category0 = cs1.Keyboard.readInt();
        while (!(category0 >= 0 && category0 < current.getChildren().size())) {
            System.out.println("\033c");
            System.out.println("Input error, please try again");
            System.out.println(current.listChildren() + "\n");
            category0 = cs1.Keyboard.readInt();
        }

        current = current.getChildren().get(category0);

        System.out.println("\033c");
        System.out.println("What would you like to solve for?");
        System.out.println(current.listChildren());
	System.out.println("9 Go Back\n");

        int category1 = cs1.Keyboard.readInt();

	if (category1 == 9) {

	}


        while (!(category1 >= 0 && category1 < current.getChildren().size())) {
            System.out.println("\033c");
            System.out.println("Input error, please try again");
            System.out.println(current.listChildren());
            category1 = cs1.Keyboard.readInt();
        }

        String methodCode = "" + category0 + "" + category1;
        System.out.println(Solver.solve(methodCode));

        
    }
}
