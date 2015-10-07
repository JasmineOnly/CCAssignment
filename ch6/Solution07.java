public class Solution07 {
	/*
	 * In this problem, we do not need to consider each family. What we need to
	 * do is to take the whole country as a big family. We know that the
	 * probability of having a girl is equal to it of having a boy. The policy
	 * doesn't change the biology, thus the gender ratio (girl/boy) is equal 1
	 */

	public static void main(String[] args){
		int n = 100000000;
		System.out.println(country(n));
	}
	
	/**
	 * simulate the fertility in the whole country
	 * 
	 * @param n
	 * @return
	 */
	public static double country(int n){
		int girl = 0;
		int boy = 0;
		
		for(int i = 0; i<n; i++){
			int[] num = family();
			girl += num[0];
			boy += num[1];
		}
		
		double ratio = girl/boy;
		return ratio;
	}
	
	/**
	 * simulate the fertility in one family
	 * 
	 * @return
	 */
	public static int[] family() {
		int girl = 0;
		int boy = 0;

		while (girl == 0) {
			double rand = Math.random();
			if (rand >= 0.5) {
				girl++;
			} else {
				boy++;
			}

		}
		int[] result = { girl, boy };
		return result;
	}
}
