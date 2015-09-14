/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Cut the String to new one with length given. Then substitute space with "%20"
 * 
 * 
 * The other idea : Firstly, scan the array to count the number of spaces and then create an array with extra triple size for spaces
 * Finally save the original array in new one according to the requirement. 
 **/

public class Solution03 {
	public String replaceSpaces(String str, int length) {		
		String s = str.substring(0,length);		
		s = s.replace(" ", "%20");					
		return s;
	}
	
	
	/*
	 * public String replaceSpaces(String str, int length) {
		char[] sArr = str.toCharArray();

		// Count the number of spaces
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (sArr[i] == ' ') {
				spaceCount++;
			}
		}

		int newLength = length + 2 * spaceCount;

		sArr[newLength]= '\0';// add the terminator to the end of the array

		// Edit the array starting with the end of the array
		for (int i = length-1; i >= 0; i--) {
			if (sArr[i] == ' ') {
				sArr[newLength - 1] = '0';
				sArr[newLength - 2] = '2';
				sArr[newLength - 3] = '%';
				newLength -= 3;
			} else {
				sArr[newLength - 1] = sArr[i];
				newLength -= 1;
			}
		}

		return String.valueOf(sArr);

	}
	 */

	

	
}
