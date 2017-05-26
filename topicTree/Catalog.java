public class Catalog {   
    private String[] listTopics =
    {"A",
     "B",
     "C",
     "D"};  
    private TopicTree treeTopics = constructTree();

    public Catalog() {
    }

    public TopicTree constructTree() {
	TopicTree newTree = new TopicTree();
	return newTree;
    }

    public String[] getList() {
	return listTopics;
    }
    
    public TopicTree getTree() {
	return treeTopics;
    }
}
