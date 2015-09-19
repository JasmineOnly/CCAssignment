/* Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Suppose the digits are stored in backward order
 * Basic idea:  Should pay attention to the length of input. 
 * If they are unequal, pad the shorter one.
 **/

public class Solution05_02 {
	
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2){
		// Handle the problem that one list maybe shorter than the other one
		int len1 = getLength(l1);
		int len2 = getLength(l2);
			
		if (len1<len2){
			l1 = pad(l1, len2-len1);
		}else {
			l2 = pad(l2, len2 -len1);
		}
		
		PartialProperty sum = addListsHelper(l1, l2); 
		if(sum.carry == 0){
			return sum.sum;
		}else{
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
		
		
		
	}
	
	public int getLength(LinkedListNode n){
		if (n == null){
			return 0;
		}
		
		int count = 0;
		
		while(n!= null){
			count++;
			n = n.next;
		}
		
		return count;
	}
	
	LinkedListNode pad(LinkedListNode n , int padding){
		LinkedListNode head = n;
		for(int i = 0; i< padding; i++){
			LinkedListNode temp = new LinkedListNode(0);
			if (n != null){
				temp.next = head;
				head = temp;
			}
		}
		return head;					
	}
	
	LinkedListNode insertBefore(LinkedListNode list, int data){
		LinkedListNode node = new LinkedListNode(data);
		if(list != null){
			node.next = list;
		}
		return node;
	}
	
	PartialProperty addListsHelper (LinkedListNode l1, LinkedListNode l2){
		if (l1 == null && l2 == null){
			PartialProperty sum = new PartialProperty();
			return sum;
		}
		
		PartialProperty sum = addListsHelper(l1.next, l2.next);
		int value = sum.carry + l1.d + l2.d;
	
		LinkedListNode result = insertBefore(sum.sum, value%10);
		sum.sum = result;
		sum.carry = value/10;
		return sum;
	}
	
	

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(6);
		LinkedListNode n2 = new LinkedListNode(1);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(7);
		n2.next = n3;

		LinkedListNode n4 = new LinkedListNode(2);
		LinkedListNode n5 = new LinkedListNode(9);
		n4.next = n5;
		LinkedListNode n6 = new LinkedListNode(5);
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
		Solution05_02 so = new Solution05_02();
		LinkedListNode result = so.addLists(n1, n4);

		System.out.println("Result: ");
		n = result;
		while (n != null) {
			System.out.print(n.d + " ");
			n = n.next;
		}
	}
}
