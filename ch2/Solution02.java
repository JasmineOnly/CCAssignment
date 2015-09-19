/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea:  Use the "Runner" technique, keep one pointer ahead of the other k nodes; 
 * when the "faster" one hits the end, the other hits the target node.
 **/
public class Solution02 {
	LinkedListNode findLastKth(LinkedListNode head, int k){
		LinkedListNode n1;
		LinkedListNode n2;
		
		n1 = head;
		for(int i = 0; i< k; i++){
			if (n1 == null) return null;
			n1 = n1.next;
		}
		
		n2 = head;
		while(n1 != null){
			n1 = n1.next;
			n2 = n2.next;
		}
		
		return n2;
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
		
		Solution02 so = new Solution02();
		LinkedListNode kth = so.findLastKth(n1, 2);
		
		System.out.println("The last 2th node:  " + kth.d);
		
		System.out.println("The last kth to the end:");
		n = kth;
		while(n != null){
			System.out.print(n.d + " ");
			n = n.next;
		}
	}
	
}
