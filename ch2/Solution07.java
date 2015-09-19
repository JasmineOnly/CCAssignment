/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam * 
 **/
public class Solution07 {
	
	
	public Result getResult(LinkedListNode head){
		if(head == null) return null;
		
		int size = 1;
		LinkedListNode curr = head;
		
		while(curr.next != null){
			size++;
			curr = curr.next;
		}
		
		return new Result(curr, size);
	
	}
	
	LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2){
		if (l1 == null || l1 == null) return null;
		
		// get the tail and size for each LinkedListNode
		Result r1 = getResult(l1);
		Result r2 = getResult(l2);
		
		// If they have different tails, there is no intersection
		if (r1.tail != r2.tail){
			return null;
		}
		
		// Set the start for each LinkedListNode
		LinkedListNode start1 = new LinkedListNode();
		LinkedListNode start2 = new LinkedListNode();
		if (r1.size > r2.size){
			start1 = getKthNode(l1, r1.size-r2.size);
			start2 = l2;
		}else{
			start1 = l1;
			start2 = getKthNode(l2, r2.size-r1.size);
			
		}
		
		while(start1 != start2){
			start1 = start1.next;
			start2 = start2.next;
		}
		
		return start1;		
	}
	
	public LinkedListNode getKthNode(LinkedListNode head, int k){
		LinkedListNode curr = head;
		while(k > 0 && curr != null ){
			curr = curr.next;
			k--;
		}
		return curr;
	}
	
	public void printLinkedList(LinkedListNode head){
		LinkedListNode curr = head;
		while(curr != null){
			System.out.print(curr.d);
			if (curr.next != null){
				System.out.print("->");
			}
			curr = curr.next; 
		}
	}
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(3);
		LinkedListNode n2 = new LinkedListNode(1);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(5);
		n2.next = n3;
		LinkedListNode n4 = new LinkedListNode(9);
		n3.next = n4;
		LinkedListNode n5 = new LinkedListNode(7);
		n4.next = n5;
		
		LinkedListNode n6 = new LinkedListNode(4);		
		LinkedListNode n7 = new LinkedListNode(6);
		n6.next = n7;
		n7.next = n5;
		LinkedListNode n8 = new LinkedListNode(2);
		n5.next = n8;
		LinkedListNode n9 = new LinkedListNode(1);
		n8.next = n9;
		
		Solution07 so = new Solution07();
		LinkedListNode result = so.findIntersection(n1, n6);
		System.out.println("LinkedList 1: ");
		so.printLinkedList(n1);
		System.out.println("\n");
		System.out.println("LinkedList 2: ");
		so.printLinkedList(n6);
		System.out.println("\n");
		System.out.println("The intersection is :" + result.d);
		
		
		
		
	}
}
