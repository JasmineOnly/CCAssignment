/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: reverse one of LinkedListNodes and then check whether they are equal
 **/
public class Solution06 {
	boolean isPalindrome(LinkedListNode n1) {
		LinkedListNode rn1 = reverseLinkedListNode(n1);
		return isEquals(n1, rn1);
		
	}

	LinkedListNode reverseLinkedListNode(LinkedListNode n) {
	
		LinkedListNode head = null;
		LinkedListNode next = null;
		LinkedListNode curr = new LinkedListNode();
		curr.d = n.d;
		curr.next = n.next;

		while (curr != null) {
			next = curr.next;
			if (head == null) {
				head = curr;
				head.next = null;
			} else {
				curr.next = head;
				head = curr;
			}
			curr = next;
		}
		

		return head;
	}
	
	boolean isEquals (LinkedListNode n1, LinkedListNode n2){
		
		LinkedListNode head1 = n1;
		LinkedListNode head2 = n2;
		
		while(head1 != null && head2 != null){
			if (head1.d != head2.d){
				return false;
			}
			
			head1 = head1.next;
			head2 = head2.next;
		
		}
		
		return (head1 == null && head2 == null );
		
	}
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(3);
		n2.next = n3;
		
		LinkedListNode n4 = new LinkedListNode(4);	
		LinkedListNode n5 = new LinkedListNode(5);
		n4.next = n5;
		LinkedListNode n6 = new LinkedListNode(4);
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
		Solution06 so = new Solution06();	
		boolean result = so.isPalindrome(n1);
		System.out.println("The LinkedList l1 is palindrome: "+ result);
		result = so.isPalindrome(n4);
		System.out.println("The LinkedList l2 is palindrome: "+ result);
		
	
		
	}

}
