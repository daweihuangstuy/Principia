import java.util.*;

public class TopicNode {
    private String data;
    private ArrayList<TopicNode> children;

    public TopicNode() {
    }

    public TopicNode(String newData) {
        data = newData;
        children = new ArrayList<TopicNode>();
    }

    public String toString() {
        return data;
    }

    // accessors
    public String getData() {
        return data;
    }
    public ArrayList<TopicNode> getChildren() {
        return children;
    }

    // mutators
    public String setData(String newData) {
        String oldData = data;
        data = newData;
        return oldData;
    }
    public ArrayList<TopicNode> setChildren(ArrayList<TopicNode> newChildren) {
        ArrayList<TopicNode> oldChildren = children;
        children = newChildren;
        return oldChildren;
    }

    // add one child to list of children
    public void addChild(TopicNode child) {
        children.add(child);
    }

    // list format of children
    public String listChildren() {
        String retStr = "";
        for (TopicNode tn : getChildren()) {
            retStr += tn.getData() + "\n";
        }
        return retStr.substring(0, retStr.length() - 1);
    }
}
