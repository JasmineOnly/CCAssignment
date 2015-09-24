
public class Solution01 {
	public static void main(String[] args){
		MultiStack stack = new MultiStack(100);
		stack.push(0, 1);
		stack.push(1, 2);
		stack.push(2, 3);
		stack.push(0, 4);
		stack.push(1, 5);

		System.out.println(stack.pop(0));
		System.out.println(stack.peek(1));
		System.out.println(stack.pop(1));
		//System.out.println(stack.pop(1));
		
	}
}



	
	

