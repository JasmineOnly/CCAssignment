public class Solution03 {
	public static void main(String[] args) {
		int n = 1775;
		System.out.println(flipBit(n));
	}

	// This function is used to find the longest sequence of 1s in an integer
	// if you can flip one bit from a 0 to a 1 in it
	public static int flipBit(int n) {
		final int MAXSEQUENCE = 32;
		int target = 0; // the figure we are looking for
		int[] counts = new int[3]; // count for the last 3 sequences
		int max = 0;// store the length of the longest 1s sequence

		if (n == -1) {
			return MAXSEQUENCE;
		}

		for (int i = 0; i < MAXSEQUENCE; i++) {
			// if the last figure is not the target, we will change the target
			if ((n & 1) != target) {
				if (target == 1) {
					max = Math.max(max, getMax(counts));
				}

				target = n & 1;
				shift(counts);
			}
			counts[0]++;// count the current target
			n >>>= 1;// check next bit

		}
		
		if (target == 0){
			shift(counts);
		}

		return Math.max(max, getMax(counts));
	}

	/*
	 * The input is the array counting 0 and 1 counts[0] and counts[2] are used
	 * to count the 1 while counts[1] is for 0
	 */
	public static int getMax(int[] counts) {
		if (counts[1] == 1) {
			return counts[0] + counts[2] + 1;
		} else if (counts[1] == 0) {
			return Math.max(counts[0], counts[2]);
		} else {
			return Math.max(counts[0], counts[2]) + 1;
		}
	}

	/*
	 * This method is used to reset the counts array
	 */
	public static void shift(int[] counts) {
		counts[2] = counts[1];
		counts[1] = counts[0];
		counts[0] = 0;
	}

}
