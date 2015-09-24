public class MultiStack {
	private int numOfStacks = 3;// The number of stacks
	private int capacity; // The capacity for each stack
	private int[] count; // Count for the elements in each stack
	private int[] values; // Store the values of each stack
	

	public MultiStack(int capacity) {
		this.capacity = capacity;
		values = new int[numOfStacks * capacity];
		count = new int[numOfStacks];

	}

	// Method: push
	public void push(int stackNum, int value) {
		if (count[stackNum] == capacity) {
			System.out.println("This stack is full!");
			return;
		} else {
			count[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}

	}
	
	// Method: pop
	public int pop(int stackNum) {
		if (count[stackNum] == 0){
			System.out.println("This stack is empty!");
		}
		int value = values[indexOfTop(stackNum)];
		values[indexOfTop(stackNum)] = 0;
		count[stackNum]--;
		return value;		
	}
	
	public int peek(int stackNum) {
		if (count[stackNum] == 0){
			System.out.println("This stack is empty!");
		}
		return values[stackNum * capacity];
		
	}

	// Method: find the index of top of the stack
	public int indexOfTop(int stackNum){
		int index = stackNum * capacity + count[stackNum]-1;
		return index;
	}
}