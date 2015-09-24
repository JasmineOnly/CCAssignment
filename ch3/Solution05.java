import java.util.Stack;
class Solution05 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(-5);
		SortStack.sort(stack);
		for (int i : stack) {
			System.out.print(i + " ");
		}
	}
}

class SortStack {
	
	public static void sort(Stack<Integer> stack) {
		Stack<Integer> buffer = new Stack<Integer>();
		while (!stack.isEmpty()) {
			if (buffer.isEmpty()) {
				buffer.push(stack.pop());
			}
			else {
				int tmp = buffer.peek();
				if (stack.peek() >= tmp) {
					buffer.push(stack.pop());
				} else {
					int val = stack.pop();
					while (!buffer.isEmpty() && buffer.peek() > val) {
						stack.push(buffer.pop());
					}
					buffer.push(val);
				}
			}
		}
		stack.addAll(buffer);
	}
}