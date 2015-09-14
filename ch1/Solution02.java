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
		
		return sArr.equals(tArr);
		
	}
}
