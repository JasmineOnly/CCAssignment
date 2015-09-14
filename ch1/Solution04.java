/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Firstly, map each character to number space; Then use the HashMap<Character, Integer>, Save each character as the key 
 * and the value to count how many times each character appears
 * 
 * In this case, the characters refer to letter characters. Non-letter characters are not considered as part of palindrome.
 * 
 **/
public class Solution04 {

	public boolean isPermutationOfPalindrome(String str) {
		java.util.HashMap<Integer, Integer> hm = new java.util.HashMap<Integer, Integer>();

		// Populate the HashMap
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			int num = CharToNum(str.charAt(i));
			if (hm.containsKey(num)) {
				temp = hm.get(num) + 1;
				hm.put(new Integer(num), new Integer(temp));
			} else {
				hm.put(new Integer(num), new Integer(1));
			}
		}

		// Check the character count. 
		// There should be no more than one character has odd count.
		int oddCount = 0;
		int value = 0;
		for (int i = 0; i < str.length(); i++) {
			if (oddCount > 1) {
				return false;
			}

			value = hm.get(CharToNum(str.charAt(i)));
			if (value % 2 == 1) {
				if( CharToNum(str.charAt(i)) != -1 ){
					oddCount++;
				}
				
			}
		}

		return true;

	}

	// Map each character to a number
	public int CharToNum(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');

		int num = 0;
		int val = Character.getNumericValue(c);

		if (a <= val && val <= z) {
			num = val - a;
		} else if (A <= val && val <= Z) {
			num = val - A;
		} else {
			num = -1;
		}

		return num;
	}
	
}
