
/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: sort the string first and then compare each term with the neighboring one 
 **/

public class Solution01 {
	boolean isUniqueChars(String str){
		
		char[] sArr = str.toCharArray();
		
		java.util.Arrays.sort(sArr);
		
		for(int i = 0; i< sArr.length-1;i++){
			if(sArr[i] == sArr[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		Solution01 so = new Solution01();
		System.out.println(so.isUniqueChars("apple"));
		System.out.println(so.isUniqueChars("great"));
		
	}
	
}
