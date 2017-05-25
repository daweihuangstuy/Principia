import java.util.*;

public final class Catalog{
    
    public static String[] listTopics =
    {"M1 Calculate Velocity",
     "M2",
     "M3",
     "etc"};

    public Tree<String> treeTopics = new Tree<String>("root");

    public Catalog() {
	treeTopics.addChild("Motion");
	treeTopics.addChild("some topic");
	treeTopics.addChild("other topic");
	//Node<String> A0 = treeTopics.getChildren().get(0);
	//A0.addChild("velocity");
    }

    public String toString() {
	return (treeTopics.getChildren()).toString();
    }

}
