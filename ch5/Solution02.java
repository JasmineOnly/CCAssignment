public class Solution02 {
	public static void main(String[] args) {
		printBinary(0.875);
		printBinary(0.72);
	}

	/*
	 * This function is used to print the binary representation of a double
	 * input The input is between 0 and 1
	 */
	public static void printBinary(double n) {
		double original = n;

		if (n < 1 && n > 0) {
			StringBuffer buffer = new StringBuffer("0.");
			while (n > 0) {
				if (buffer.length() > 32) {
					System.out.println("Error!");
					break;
				}

				double temp = n * 2;
				if (temp >= 1) {
					buffer.append("1");
					n = temp - 1;
				} else {
					buffer.append("0");
					n = temp;
				}

			}

			if (buffer.length() <= 32) {
				System.out.println("The binary presentation of " + original
						+ ": "
						+ buffer.toString());
			}
		} else {
			System.out.println("Error!");
		}
	}
}
