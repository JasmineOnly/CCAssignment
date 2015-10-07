
public class Solution06 {	
	/*
	 * Assume that all the people in this island are intelligent.
	 * 
	 * Initially, we consider the case that there is only one person with blue eyes.
	 * When the person with blue eyes finds that no one has blue eyes, 
	 * then he will realize he is the only person has blue eyes. 
	 * He will leave that night.
	 * 
	 * Then we check the case that there are two people with blue eyes. 
	 * When the two people with blue eyes see each other, 
	 * both of them can deduce that there should two people with blues eyes,
	 * The reason is as following: if there is only one person with blue eyes,
	 * the person with blue eyes his see should leave on first day. (as mentioned before)
	 * 
	 * ....
	 * 
	 * In general case, there are k people with blue eyes.
	 * Each person with blue eyes see the other k-1 people with blue eyes on Kth day,
	 * he can realize that there are k people with blue eyes, otherwise the k-1 people with 
	 * blue eyes should leave yesterday. 
	 * Thus the k people will leave on Kth day together.
	 * 
	 * Now we can draw a conclusion that it will take k days that the blue-eyed people to leave.
	 * 
	 * 
	 * 
	 */

}
