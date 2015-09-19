/* Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea:  Use the "Runner" technique, keep one pointer ahead of the other k nodes; 
 * when the "faster" one hits the end, the other hits the target node.
 **/
public class Solution03 {
	boolean deleteNode(LinkedListNode n){
		if (n == null | n.next == null)
			return false;
		
		LinkedListNode next = n.next;
		n.next = next.next;
		n.d = next.d;
		return true;
	}
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(3);
		n2.next = n3;
		LinkedListNode n4 = new LinkedListNode(4);
		n3.next = n4;
		
		
		System.out.println("Original LinkedList: ");
		LinkedListNode n = n1;
		while(n != null){
			System.out.print(n.d + " ");
			n = n.next;
		}
		
		System.out.println(" ");
		Solution03 so = new Solution03();
		boolean b = so.deleteNode(n2);
		if (b){
			System.out.println("The new LinkedList: ");
			n = n1;
			while(n != null){
				System.out.print(n.d + " ");
				n = n.next;
			}
		}else{
			System.out.println("The node to be deleted is null or it's the last node of the linked list");
		}
		
		
	}
}
