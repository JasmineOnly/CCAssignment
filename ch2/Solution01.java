/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Use HashSet to save the LinkedList.
 **/
public class Solution01 {
	void deleteDups(LinkedListNode n){
		java.util.HashSet<Integer> hs = new java.util.HashSet<Integer> ();
		
		LinkedListNode previous = null;
		while(n != null){
			if(hs.contains(n.d)){
				previous.next = n.next;			
			}else{
				hs.add(new Integer(n.d));
				previous = n;
			}
			n = n.next;
		}
		
	}
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(3);
		n2.next = n3;
		LinkedListNode n4 = new LinkedListNode(3);
		n3.next = n4;
		
		
		System.out.println("Original LinkedList: ");
		LinkedListNode n = n1;
		while(n != null){
			System.out.print(n.d + " ");
			n = n.next;
		}
		
		Solution01 so = new Solution01();
		so.deleteDups(n1);
		
		System.out.println("After delete duplicates:  ");
		n = n1;
		while(n != null){
			System.out.print(n.d + " ");
			n = n.next;
		}
	}
}
