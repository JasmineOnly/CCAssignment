
public class Solution05 {
	/*
	 * Initially, we know that n and n-1 must have no 1s in common.
	 * 
	 * Now we consider two special cases: one is n = 1, the other is n = 0;
	 * 		When n = 1, n - 1 = 0. It matches the condition.
	 * 		When n = 0, n - 1 = -1. It also matches the condition.
	 * 
	 * In general, we set n = abcd1000, n-1 = abcd0111. In order to matches the condition, abcd should be 0s.
	 * That means n should be like 00001000, in other words, n is a power of 2.
	 * 
	 * Then we check the two special cases mentioned above, we can find that n=1 is also a power of 2.
	 * 
	 * In a conclusion, ((n & (n-1)) == 0) indicates that n is a power of 2 or n = 0;
	 * 
	 */

}
