public class Solution02 {
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(5);
		stack.push(6);
		stack.push(8);
		stack.push(9);
		stack.push(3);
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());
	}
}

class StackWithMin extends Stack {
	Stack s2 = new Stack();

    // if the element is the smallest, push it into the s2
	public void push(int value) {
		if (value <= getMin()) {
			s2.push(value);
		}
		super.push(value);
	}

    //if the element is the minimum, pop it in both stacks
	public Integer pop() {
		int top = super.pop();
		if (top == getMin()) {
			s2.pop();
		}
		return top;
	}

    // return the minmum from stack s2
	public int getMin() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}

}
