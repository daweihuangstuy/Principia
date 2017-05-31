import java.util.*;

public class TopicTree {
    private TopicNode root;

    public TopicTree() {
    }
    
    public TopicTree(String topic) {
        root = new TopicNode(topic);
    }

    public void addChildren(TopicTree... children) {
        for (TopicTree t : children) {
            root.addChild(t.getRoot());
        }
    }

    public TopicNode getRoot() {
        return root;
    }

    public ArrayList<TopicNode> getChildren() {
        return root.getChildren();
    }

}
