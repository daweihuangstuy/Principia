public class TopicNode{
    String topic = "";
    TopicNode[] subTopics = null;

    //accessor
    public String getTopic(){
	return topic;
    }

    public String getSubTopics(){
	return subTopics
    }
    
    //mutators
    public String setTopic(String newTopic){
	topic = newTopic;
	return topic;
    }
    
    public String setSubTopics(TopicNode[] newSubTopic){
	subTopics = newSubTopic;
	return subTopic;
    }
    
}
