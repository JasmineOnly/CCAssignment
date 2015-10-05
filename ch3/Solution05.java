
public class Solution05 {
    
    // based on the insertion sort
	public static Stack sortStack (Stack s1){
		Stack s2 = new Stack();
		while(! s1.isEmpty()){
			int temp = s1.pop();
			while(!s2.isEmpty() && s2.peek() < temp){
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}
    
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(1);
		Stack sortedStack = sortStack(stack);
		while(! sortedStack.isEmpty()) {
			System.out.print(sortedStack.pop() + " ");
		}
	}

}
