
public class Solution10 {
	/*
	 * The basic idea is mapping each bottle to a binary number.
	 * 
	 * Why we can do that?  
	 * We should think about the meaning of the test strip.
	 * It actually is a kind of binary indicator. 
	 * It only can tell you two different result: poisoned or non-poisoned.
	 * 
	 * How can we do that? 
	 * Initially, we need to number the bottles from 1 to 1000 by binary representation.
	 * Then, if there is a 1 on ith digit, we will add a drop of the bottle 's contents to test trip i.
	 * You may ask can 10 test trips handle all the bottles?
	 * The answer is absolutely yes. 2^10 = 1024 > 1000.
	 * 
	 * The last thing we need to do is wait for 7 day to check the results. 
	 * We can find the bottle corresponding with the ID that the test strips indicate.
	 * 
	 */
}
