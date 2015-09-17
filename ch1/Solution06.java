/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Create two pointers, one points the start, the other points the end. 
 * Use the StringBuffer to append the characters
 * 
 **/
public class Solution06 {
	String compress(String s) {
		StringBuffer buffer = new StringBuffer();
		int start = 0;
		int end = 1;

		while (end < s.length()) {
			if (s.charAt(start) == s.charAt(end)) {
				if (end == s.length() - 1) {
					buffer.append(s.charAt(start)).append(end - start + 1);
					break;
				} else {
					end++;
				}

			} else {
				buffer.append(s.charAt(start)).append(end - start);
				if (end == s.length() - 1) {
					buffer.append(s.charAt(end)).append(1);
					break;
				} else {
					start = end;
					end++;
				}
			}
		}

		if (buffer.length() > s.length()) {
			return s;
		} else {
			return buffer.toString();
		}

	}

	public static void main(String[] args) {
		Solution06 so = new Solution06();
		System.out.println(so.compress("aabcccccaaa"));
		System.out.println(so.compress("aabcccccaaac"));

	}

}
