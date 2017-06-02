public class Catalog {   

    private TopicTree treeTopics = constructTree();

    public Catalog() {
    }

    public TopicTree constructTree() {
	TopicTree _0 = new TopicTree("root");

        TopicTree _00 = new TopicTree("0 Kinematics");
        TopicTree _01 = new TopicTree("1 Forces");
        TopicTree _02 = new TopicTree("2 Energy and Power");
        TopicTree _03 = new TopicTree("3 Momentum");
        TopicTree _04 = new TopicTree("4 Waves");
        TopicTree _05 = new TopicTree("5 Fluids");
        TopicTree _06 = new TopicTree("6 Thermodynamics");
        TopicTree _07 = new TopicTree("7 Electromagnetism");
        TopicTree _08 = new TopicTree("8 Optics");
        TopicTree _09 = new TopicTree("9 Quantum and Nuclear");
        _0.addChildren(_00, _01, _02, _03, _04,
                        _05, _06, _07, _08, _09);

        TopicTree _000 = new TopicTree("0 Displacement");
        TopicTree _001 = new TopicTree("1 Velocity");
        TopicTree _002 = new TopicTree("2 Acceleration");
        _00.addChildren(_000, _001, _002);

        TopicTree _010 = new TopicTree("0 Weight");
        TopicTree _011 = new TopicTree("1 Spring");
        TopicTree _012 = new TopicTree("2 Friction");
	TopicTree _013 = new TopicTree("3 Centripetal");
        _01.addChildren(_010, _011, _012, _013);
	   
        TopicTree _020 = new TopicTree("0 Work");
        TopicTree _021 = new TopicTree("1 Kinetic Energy");
        TopicTree _022 = new TopicTree("2 Potential Energy");
	TopicTree _023 = new TopicTree("4 Power");
        _02.addChildren(_020, _021, _022, _023);
            
	return _0;
    }
    
    public TopicTree getTree() {
	return treeTopics;
    }
    
}
