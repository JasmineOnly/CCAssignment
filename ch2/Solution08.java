/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 **/
public class Solution08 {
	public LinkedListNode findLoop(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast){
				break;
			}
		}
		
		if (fast == null || fast.next == null){
			return null;
		}
		
		slow =head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	public void printLinkedList(LinkedListNode head){
		LinkedListNode curr = head;
		int count = 0;
		while(count < 6){
			System.out.print(curr.d);
			if (count < 5){
				System.out.print("->");
			}
			curr = curr.next; 
			count++;
		}
	}
	
	public static void main(String[] args){
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(3);
		n2.next = n3;
		LinkedListNode n4 = new LinkedListNode(4);
		n3.next = n4;
		LinkedListNode n5 = new LinkedListNode(5);
		n4.next = n5;
		n5.next = n3;
		
		Solution08 so = new Solution08();
		so.printLinkedList(n1);
		System.out.println(" ");
		LinkedListNode result = so.findLoop(n1);
		System.out.println("The begining of loop is : " + result.d);
		
	}
}
