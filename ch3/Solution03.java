import java.util.*;

class Solution03 {
	public static void main(String[] args) {
		SetOfPlates stack = new SetOfPlates();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}

class SetOfPlates {
	public static int capacity = 3;
	public static ArrayList<NewStack> lists = new ArrayList<NewStack>();
	
	public static void push (int val) {
		int index = lists.size();
		if (index == 0) {
			NewStack stack = new NewStack();
			stack.push(val);
			lists.add(stack);
		} else {
			if (lists.get(index - 1).size() >= capacity) {
				NewStack stack = new NewStack();
				stack.push(val);
				lists.add(stack);		
			} else {
				lists.get(index - 1).push(val);
			}
		}
	}

	public static int pop() {
		int size = lists.size();
		if (size == 0) {
			System.out.println("stack is empty!");
			return -1;
		} else {
			int result = lists.get(size - 1).pop();
			if (lists.get(size - 1).isEmpty()) {
				lists.remove(size - 1);
			}
			return result;
		}
	}

}

class NewStack {
	
	public int size = 0;
	// Inner class StackNode
	private static class StackNode<Integer> {
		private Integer data;
		private StackNode<Integer> next;

		public StackNode(Integer data) {
			this.data = data;
		}
	}

	private StackNode<Integer> top;

	public Integer pop() {
		if (top == null) {
			System.out.println("The stack is empty!");
		}
		size--;
		Integer item = top.data;
		top = top.next;
		return item;
	}
	
	public void push(Integer data){
		StackNode t = new StackNode(data);
		t.next = top;
		top = t;
		size++;
	}
	
	public Integer peek(){
		if(top == null){
			System.out.println("This stack is empty!");
		}
		return top.data;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size()
	{
		return size;
	}	
	

}


