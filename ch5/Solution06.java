
public class Solution06 {
	public static void main(String[] args){
		int a = 29;
		int b = 15;
		System.out.println(numSwap(a, b));
	}
	public static int numSwap(int a, int b){
		int count = 0;
		// count for the 1s in a^b
		for(int c = a ^ b; c != 0; c >>= 1){
			/* if ( (c & 1) == 1){
			 *	count++;
			}*/
			
			count += c & 1;
		}
		
		return count;
	}

}
