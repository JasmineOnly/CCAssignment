/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: sort the string first and then check whether they are equal to each other 
 * Assume that the whitespace is significant
 **/

public class Solution02 {
	
	boolean permutation(String s, String t){
		if (s.length() != t.length()){
			return false;
		}
		
		// Sort the char array
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		java.util.Arrays.sort(sArr);
		java.util.Arrays.sort(tArr);
		
		return new String(sArr).equals(new String(tArr));
		
	}
	
	public static void main(String[] args){
		Solution02 so = new Solution02();
		System.out.println(so.permutation("dog", "god"));
		System.out.println(so.permutation("abc", "efg"));
		
	}
}
