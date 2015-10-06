import java.util.*;

public class GraphNode {
	int val;
	boolean flag;
	LinkedList<GraphNode> adjacent;
	
	// Constructor
	public GraphNode(int val){
		this.val = val;
		adjacent = new LinkedList<GraphNode>();
	}
	
	LinkedList<GraphNode> getAdjacent(){
		return this.adjacent;
	}
	
	boolean getFlag(){
		return flag;
	}
	
	void setFlag(boolean flag){
		this.flag = flag;
	}
	

}
