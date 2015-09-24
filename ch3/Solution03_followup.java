import java.util.ArrayList;


public class Solution03_followup {
	public static class SetOfStacks<T> {
		//Each sub-stack limitation capacity
		private int capacity;
		
		//Create a arraylist of MyStacks.	
		ArrayList<MyStack> stacks = new ArrayList<MyStack>();
		
		//Constructor 
		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}
		
		// Push an element into the stack		 
		public void push(Integer data) {
			MyStack lastStack = getLastStack();
			
			if(lastStack != null && !lastStack.isFull()) {
				lastStack.push(data);
			}else {
				MyStack newStack = new MyStack(capacity);
				newStack.push(data);
				stacks.add(newStack);
			}
		}
		
		//Pop an element from the stack
		public Integer pop() {
		    MyStack last = getLastStack();
			if(last == null){
				System.out.println("The last stack is null!");
			}
			Integer data = last.pop();
			if(last.size == 0) 
				stacks.remove(stacks.size()-1);
			return data;
		}
		
		// This method is to check the stacks is empty or not
		public boolean isEmpty() {
			MyStack last = getLastStack();
			return (last == null || last.size == 0);
		}
		
		//This method is to get the sub-stack top data.
		public 	Integer popAt(int index) {
			if(index<0 || index>stacks.size()) {
				System.out.println("Out of bounds!");
				System.exit(1);
			}
			
			return leftShift(index, true);
		}
		
		//This method is to left shift the next stack bottom data to the previous stack top.
		public Integer leftShift(int index, boolean removeTop) {
			MyStack stack = stacks.get(index);
			Integer data;
			if(removeTop) data = stack.pop();
			else data = stack.removeBottom();
			
			if(stack.isEmpty()) {
				stacks.remove(index);
			}else if(stacks.size()>index+1) {
				Integer v = leftShift(index+1, false);
				stack.push(v);
			}
			return data;
		}
		
		/**
		 * This method is to get the last stack in the stack arraylist
		 */
		public MyStack getLastStack() {
			if(stacks.size() == 0) return null;
			return stacks.get(stacks.size()-1);
		} 
		
	}
}
