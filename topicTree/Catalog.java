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
	TopicTree _000 = new TopicTree("root");

        TopicTree _100 = new TopicTree("0 Kinematics");
        TopicTree _110 = new TopicTree("1 Forces");
        TopicTree _120 = new TopicTree("2 Energy and Power");
        TopicTree _130 = new TopicTree("3 Momentum");
        TopicTree _140 = new TopicTree("4 Waves");
        TopicTree _150 = new TopicTree("5 Fluids");
        TopicTree _160 = new TopicTree("6 Thermodynamics");
        TopicTree _170 = new TopicTree("7 Electromagnetism");
        TopicTree _180 = new TopicTree("8 Optics");
        TopicTree _190 = new TopicTree("9 Quantum and Nuclear");
        _000.addChildren(_100, _110, _120, _130, _140,
                        _150, _160, _170, _180, _190);

        TopicTree _101 = new TopicTree("0 Displacement");
        TopicTree _102 = new TopicTree("1 Velocity");
        TopicTree _103 = new TopicTree("2 Acceleration");
        _100.addChildren(_101, _102, _103);

        TopicTree _111 = new TopicTree("0 Gravitational");
        TopicTree _112 = new TopicTree("1 Spring");
        TopicTree _113 = new TopicTree("2 Friction");
        _110.addChildren(_111, _112, _113);
            
	return _000;
    }

    public String[] getList() {
	return listTopics;
    }
    
    public TopicTree getTree() {
	return treeTopics;
    }
}
