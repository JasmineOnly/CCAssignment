
public class Solution04 {
	public static void main(String[] args) {
        NewQueue queue = new NewQueue();
        queue.add(1);
        queue.add(2);
        System.out.println("The peek of the queue is " + queue.peek());
        queue.remove();
        System.out.println("The peek of the queue is " +queue.peek());
    }


}
class NewQueue{
	Stack newest = new Stack();
	Stack oldest = new Stack();
	
	// push the newest item to stack newest
	public void add(Integer value){
		newest.push(value);
	}
	
	// use the second stack to reverse the order of the element
	public void stackShift(){
		if (oldest.isEmpty()){
			while(! newest.isEmpty()){
				int temp = newest.pop();
				oldest.push(temp);			
			}
		}
	}
	
	public int remove(){
		stackShift();
		return oldest.pop();	
	}
	
	public int peek(){
		stackShift();
		return oldest.peek();
	}
}