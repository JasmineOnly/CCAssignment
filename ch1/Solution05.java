/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Initially. we can determine which type edit may perform according to the length of strings.
 * If string1 can be gained by inserting one character into string2, then we can get string2 by removing one 
 * character from string.
 * 
 **/
public class Solution05 {
	boolean isOneEdit(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return isReplace(s1, s2);
		}

		if (s1.length() - s2.length() == 1 || s2.length() - s1.length() == 1) {
			return isInsert(s1, s2);
		}

		return false;
	}

	boolean isReplace(String s1, String s2) {
		int countDiff = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				countDiff++;
			}

			if (countDiff > 1)
				return false;
		}

		return true;
	}

	boolean isInsert(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return isInsert(s2, s1);
		}

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				String subS1 = s1.substring(i, s1.length() - 1);
				String subS2 = s2.substring(i + 1, s2.length() - 1);
				return subS1.equals(subS2);
			}
		}

		return true;
	}
	
	public static void main(String[] args){
		Solution05 so = new Solution05();
		System.out.println(so.isOneEdit("ple", "pale"));
		System.out.println(so.isOneEdit("pales", "pale"));
		System.out.println(so.isOneEdit("bale", "pale"));
		System.out.println(so.isOneEdit("pale", "bae"));
		
	}

}
