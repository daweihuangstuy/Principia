import java.util.*;

public class TopicNode {
    private String data;
    private TopicNode parent;
    private ArrayList<TopicNode> children;

    public TopicNode() {
    }

    public TopicNode(String newData) {
        data = newData;
    }

    public String toString() {
        return data;
    }

    public String getData() {
        return data;
    }
    public TopicNode getParent() {
        return parent;
    }
    public ArrayList<TopicNode> getChildren() {
        return children;
    }

    public String setData(String newData) {
        String oldData = data;
        data = newData;
        return oldData;
    }
    public TopicNode setParent(TopicNode newParent) {
        TopicNode oldParent = parent;
        parent = newParent;
        return oldParent;
    }
    public ArrayList<TopicNode> setChildren(ArrayList<TopicNode> newChildren) {
        ArrayList<TopicNode> oldChildren = children;
        children = newChildren;
        return oldChildren;
    }
}
