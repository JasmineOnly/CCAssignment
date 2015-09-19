/* Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea:  Use the "Runner" technique, keep one pointer ahead of the other k nodes; 
 * when the "faster" one hits the end, the other hits the target node.
 **/

public class Solution04 {
	public LinkedListNode partition(LinkedListNode n, int x) {
		LinkedListNode top = n;
		LinkedListNode bottom = n;

		while (n != null) {
			LinkedListNode next = n.next;
			if (n.d < x) {
				n.next = top;
				top = n;
			} else {
				bottom.next = n;
				bottom = n;
			}
			n = next;
		}

		bottom.next = null;
		return top;
	}

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(3);
		LinkedListNode n2 = new LinkedListNode(5);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(8);
		n2.next = n3;
		LinkedListNode n4 = new LinkedListNode(5);
		n3.next = n4;
		LinkedListNode n5 = new LinkedListNode(10);
		n4.next = n5;
		LinkedListNode n6 = new LinkedListNode(2);
		n5.next = n6;
		LinkedListNode n7 = new LinkedListNode(1);
		n6.next = n7;

		System.out.println("Original LinkedList: ");
		LinkedListNode n = n1;
		while (n != null) {
			System.out.print(n.d + " ");
			n = n.next;
		}

		System.out.println(" ");
		Solution04 so = new Solution04();
		LinkedListNode nn = so.partition(n1, 5);

		System.out.println("The new LinkedList: ");
		n = nn;
		while (n != null) {
			System.out.print(n.d + " ");
			n = n.next;
		}
	}

}
