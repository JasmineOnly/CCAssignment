public class Stack {
	// Inner class StackNode
	private static class StackNode<Integer> {
		private int data;
		private StackNode<Integer> next;

		public StackNode(int data) {
			this.data = data;
		}
	}

	private StackNode<Integer> top;

    // pop the top element
	public Integer pop() {
		if (top == null) {
			System.out.println("The stack is empty!");
		}
		Integer item = top.data;
		top = top.next;
		return item;
	}
	
    // push the element to the top
	public void push(Integer data){
		StackNode t = new StackNode(data);
		t.next = top;
		top = t;
	}
	
    // return the top element
	public Integer peek(){
		if(top == null){
			System.out.println("This stack is empty!");
		}
		return top.data;
	}
	
    // determine whether the stack is empty
	public boolean isEmpty(){
		return top == null;
	}
	
	

}
