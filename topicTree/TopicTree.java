import java.util.*;

public class TopicTree {
    private TopicNode root;
    
    public TopicTree() {
        root = new TopicNode("root");
    }

    public void addChild(String newData) {
        root.getChildren().add(new TopicNode(newData));
    }

    public ArrayList<TopicNode> getChildren() {
        return root.getChildren();
    }           
}
