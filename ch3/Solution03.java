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
	public static ArrayList<Stack<Integer>> lists = new ArrayList<Stack<Integer>>();
	public static void push (int val) {
		int index = lists.size();
		if (index == 0) {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(val);
			lists.add(stack);
		} else {
			if (lists.get(index - 1).size() >= capacity) {
				Stack<Integer> stack = new Stack<Integer>();
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