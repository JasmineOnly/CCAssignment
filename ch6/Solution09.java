
public class Solution09 {
	/*
	 * Firstly, we need to think about when will a door (No.n) be toggled? 
	 * For round k, where k is the factor of n.
	 * 
	 * Secondly, we can see that the door will be open when it is toggled odd times.
	 * That means we need to find n having odd factors. 
	 * The factors usually appear in pair. For example, the factors of 12 is (1,12),
	 * (2,6), (3,4). Then when would the number of the factor be odd? Perfect squares
	 * One pair of factors actual consists of only one figure.
	 * 
	 * Now the only thing we need to do is finding the perfect squares below 100:
	 * 1,4,9,16,25,26,49,64,81,100.
	 * 
	 * Thus there are ten lockers open
	 */

}
