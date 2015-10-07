
public class Solution02 {
	/*
	 * We assume the probability of making the hoop is p
	 * 
	 * Then the probability of winning game 1 is p
	 * 
	 * For game 2, there are two ways to win: one is making two shots, the other is making three shots.
	 * The probability of making two shots is C(2,3) * (p^2)  *(1-p)^3, where C is for combination.
	 * The probability of making threee shots is C(3,3) * (p^3)
	 * Thus, the probability of winning game 2 is  [C(2,3) * (p^2)  *(1-p)^3] + [C(3,3) * (p^3)],
	 * which is equal to  (-2 * p^3 + 3 * p^2)
	 * 
	 * We will play game 1 only when the probability of winning game 1 is greater than game 2.
	 * That means p should be greater than (-2 * p^3 + 3 * p^2)
	 * In other words, 2 * p^3 - 3 * p^2 + p > 0.
	 * We assume the p is not equal to 0 (discuss later), then we just need to solve the following quadratic inequality:
	 * 2 * p^2 - 3 * p + 1 > 0. ( 0 < p < 1)
	 * The solution of it is ( 0 < p < 1/2)
	 * 
	 * In similar way, we know that we will play game 2 only when ( 1/2 < p < 1)
	 * 
	 * When p = 0, 1/2, 1, it doesn't matter we choose which game.
	 */
}
