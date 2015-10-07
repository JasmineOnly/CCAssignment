public class Solution04 {
	public static void main(String[] args) {
		int n1 = 10115;
		int n2 = 13948;
		System.out.println(Integer.toBinaryString(getNextSmall(n1)));
		System.out.println(Integer.toBinaryString(getNextLarge(n2)));
	}

	/**
	 * This function is used to find the next smallest number
	 * 
	 * @param n
	 * @return
	 */
	public static int getNextSmall(int n) {
		// count the 0 and 1 that to the right of the non-trailing 1
		int c0 = 0;
		int c1 = 0;
		int temp = n;
		int p = 0;

		while (temp != 0) {
			if ((temp & 1) == 0) {
				c0++;
			} else {
				// find the rightmost non-trailing 1
				if (c0 != 0) {
					p = c0 + c1;
					break;
				} else {
					c1++;
				}
			}
			temp >>= 1;
		}

		// set a mask to clear the bits the right of p
		int mask = (~0) << (p + 1);

		n &= mask;
		n |= ((1 << (c1 + 1)) - 1) << (c0 - 1);

		return n;

	}

	/**
	 * This function is used to find the next largest number
	 * 
	 * @param n
	 * @return
	 */
	public static int getNextLarge(int n) {
		// count the 0 and 1 that to the right of the non-trailing 0
		int c0 = 0;
		int c1 = 0;
		int temp = n;
		int p = 0;

		while (temp != 0) {
			if ((temp & 1) == 1) {
				c1++;
			} else {
				// find the non-trailing 0
				if (c1 != 0) {
					p = c0 + c1;
					break;
				} else {
					c0++;
				}
			}
			temp >>= 1;
		}

		// set the rightmost non-trailing 0 as 1
		n |= 1 << p;
		// set a mask to clear the bits the right of p
		int mask = (~0) << p;

		n &= mask;
		n |= (1 << (c1 - 1)) - 1;

		return n;
	}

}
