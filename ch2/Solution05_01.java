/* Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Suppose the digits are stored in backward order
 *
 **/
public class Solution05_01{
	public LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2,int carry ){
		if ( l1 == null && l2 == null && carry == 0){
			return null;
		}
		
		
		int value = carry;
		if (l1 != null){
			value += l1.d;		
		}
		
		if (l2 != null){
			value += l2.d;		
		}
		
		LinkedListNode result = new LinkedListNode();
		result.d = value % 10;
		
		if(l1 != null || l2 != null){
			LinkedListNode more = addLists(l1 == null ? null: l1.next, l2 == null ? null : l2.next, value >= 10 ? 1: 0);
			result.next = more;
		}
		
		
		return result ;
	}
	
	
	////////////////  Test //////////////////////
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(7);
		LinkedListNode n2 = new LinkedListNode(2);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(6);
		n2.next = n3;
		
		LinkedListNode n4 = new LinkedListNode(5);	
		LinkedListNode n5 = new LinkedListNode(9);
		n4.next = n5;
		LinkedListNode n6 = new LinkedListNode(2);
		n5.next = n6;
		

		System.out.println("Original LinkedList l1: ");
		LinkedListNode n = n1;
		while (n != null) {
			System.out.print(n.d + " ");
			n = n.next;
		}
		System.out.println(" ");
		
		System.out.println("Original LinkedList l2: ");
		n = n4;
		while (n != null) {
			System.out.print(n.d + " ");
			n = n.next;
		}

		System.out.println(" ");
		Solution05_01 so = new Solution05_01();
		LinkedListNode result = so.addLists(n1, n4,0);
		
		System.out.println("Result: ");
		n = result;
		while (n != null) {
			System.out.print(n.d + " ");
			n = n.next;
		}
	}

}


