
public class Solution07 {
	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(6));
		System.out.println(Integer.toBinaryString(swapEvenOdd(6)));
	}
	public static int swapEvenOdd(int n){
		// get the even bits by 0xaaaaaaaa : 10101010....
		// get the odd bits by 0x55555555 : 01010101...
		return (((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1) );
	}

}
