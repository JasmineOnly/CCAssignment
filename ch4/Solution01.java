import java.util.LinkedList;

public class Solution01 {
	public static void main(String[] args){
		GraphNode n1= new GraphNode(1);
		GraphNode n2= new GraphNode(2);
		GraphNode n3= new GraphNode(3);
		n1.adjacent.add(n2);
		System.out.println(isConnected(n1,n2));
		System.out.println(isConnected(n1,n3));
	}
	
	public static boolean isConnected(GraphNode a, GraphNode b) {
		if (a == null || b == null) {
			return false;
		}

		if (a == b) {
			return true;
		}

		for (GraphNode n : a.adjacent) {
            // check whether this node is checked or not
			if (!n.flag) {
				n.setFlag(true);
				if (n == b) {
					return true;
				} else {
					return isConnected(n, b);
				}
			}		
		}
		
		return false;
	}
	

}


