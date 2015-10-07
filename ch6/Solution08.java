
public class Solution08 {
	/*
	 * Firstly, we want the number of drops of Egg1 as consistent as possible
	 * Secondly, we want to reduce the potential steps for Egg2, 
	 * which means the difference between two drops of Egg1 can not too big.
	 * 
	 * Therefore, Egg1 starts at floor x, then go up by x-1, x-2, ... , 1 .until it the 100
	 * So we need to solve the following equation:
	 *      x + (x-1) + ... + 1 = 100 
	 * =>   (x+1)*x/2=100
	 * =>   x = 13.65
	 * 
	 * If we select x = 14, let's see what happens
	 * Initially,  we consider the last increment. It is 4 and happens on floor 99.
	 * If the Egg1 haven't been broken before floor 99, 
	 * then just need one step to know whether the Egg can be broken on floor 100;
	 * If the Egg1 has been broken before floor 99, 
	 * then the number of drops is no more than 14.
	 * 
	 * If we select x = 13, the situation will be different
	 * We also consider the last increment firstly. It is 1 and happens on floor 91.
	 * If the Egg1 is still intact, we can not use one more drop to determine the floor.
	 * In other words, in the worse case, the number of drops is more than 14.
	 * 
	 * Thus we need to drop Egg1 at 14, then 27, ... In the worse case, the number of drops is 14
	 * 
	 * 
	 */

}
