
public class Solution04 {
	/*
	 * There is only one situation that the ants would not collide: 
	 * all the ants choose the same direction.
	 * 
	 * As they randomly pick a direction, thus the probability that choosing one of directions is 1/2
	 * Then the probability that they choose the same direction is C(1/2) * (1/2)^3 = 1/4
	 * where C is for combination.
	 * 
	 * Thus the probability of collision with the other ants is (1-1/4) = 3/4
	 * 
	 * In general. there are n ants on an n-vertex polygon.
	 * The probability that they choose the same direction is C(1/2) * (1/2)^n = (1/2)^(n-1)
	 * Thus the probability of collision with the other ants is [1-(1/2)^(n-1)] 
	 *
	 */
}
