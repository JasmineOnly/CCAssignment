public class MyStack {

	private int capacity;
	public StackNode top;
	public StackNode bottom;
	public int size = 0;

	// Constructor with arguments
	public MyStack(int capacity) {
		this.capacity = capacity;
	}

	private static class StackNode {
		private Integer data;
		private StackNode next;
		private StackNode above;

		public StackNode(Integer data) {
			this.data = data;
		}
	}

	// This method is to get an item from the top of the stack and remove it;
	public Integer pop() {
		if (top == null) {
			System.out.println("The top stack is empty!");
		}

		Integer item = top.data;
		size--;
		top = top.next;
		return item;
	}

	// This method is to push an item to the top of the stack.
	public void push(Integer item) {
		if (size > capacity)
			return;

		StackNode t = new StackNode(item);
		size++;
		if (size == 1)
			bottom = t;
		if (top != null) {
			top.above = t;
		}
		t.next = top;
		top = t;
	}

	// This method is to return the top item from the stack but do not remove
	// the top
	public Integer peek() {
		if (top == null) {
			System.out.println("The top stack is empty!");
		}
		return top.data;
	}

	// This method is to check the stack is empty or not
	public boolean isEmpty() {
		return size == 0;
	}

	// This method is to check whether this stack is full or not.
	public boolean isFull() {
		return size == capacity;
	}

	// This method is to remove the sub-stack bottom data
	public Integer removeBottom() {
		StackNode node = bottom;
		bottom = bottom.above;
		if (bottom != null)
			bottom.next = null;
		size--;
		return node.data;
	}
}
