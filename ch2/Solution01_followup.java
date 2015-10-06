

public class Solution01_followup {
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
		
		System.out.println(" ");
		deleteDups(n1);
		
		System.out.println("After delete duplicates:  ");
		n = n1;
		while(n != null){
			System.out.print(n.d + " ");
			n = n.next;
		}
	
	}
	// If there is no buffer, we need two pointers. 
	// One for iterate to check whether is equal to the current one
	public static void  deleteDups(LinkedListNode head){
		LinkedListNode n1 = head;  
		
		while(n1 != null){
			LinkedListNode n2 = n1;
			while(n2.next != null){
				if (n2.next.d == n1.d){
					n2.next = n2.next.next;
				}else{
					n2 = n2.next;
				}
				n1 = n1.next;
				
			}
		}
	}
}
