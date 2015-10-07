public class Solution01 {
	public static void main(String[] args){
		int n = 1<<10; 
		int m = (1<<4)+3;
		System.out.println(Integer.toBinaryString(insertBits(n, m, 2, 6)));
		
	}
	/*
	 * This function is used to insert M into N 
	 * M start at bit j and ends at bit i
	 */
	public static int insertBits (int n, int m, int i, int j){
		// clear the bits j through i in N
		int clearedN = clearBits(n, i, j );
		// shirt M so that it lines up with bits j through i
		int shiftedM = m << i;
		// merge M and N
		return clearedN | shiftedM;			
	}

	/*
	 * This function is used to clear the the bits j through i in N (j>i)
	 */
	public static int clearBits(int N, int i, int j) {

		/** Create the mask **/
		// Create a sequence of all 1s
		int allOnes = ~0;

		// Create the left of the mask That looks like 1s before position j
		// ,then 0s
		int left = allOnes << (j + 1);

		// Create the right of the mask
		// That looks like 0s before position i, then 1s
		int right = ((1 << i) - 1);

		// Merge the mask which is all 1s except for 0s between i and j
		int mask = left | right;

		// clear bits between i and j in n
		int clearedN = N & mask;

		return clearedN;
	}

}
