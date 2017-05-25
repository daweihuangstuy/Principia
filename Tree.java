import java.util.*;

public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public void addChild(String data){
	root.children.add(new Node(data));
    }

    public ArrayList<Node<T>> getChildren(){
	return root.children;
    }
    
    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private ArrayList<Node<T>> children;

	public Node(){
	}

	public Node(T newData){
	    data = newData;
	}
    }
}
