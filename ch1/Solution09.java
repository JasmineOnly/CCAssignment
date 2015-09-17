/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * 
 * 
 **/
public class Solution09 {
	boolean isRotation(String s1, String s2){
		if (s1.length() != s2.length() || s2.length() == 0){
			return false;
		}
		
		String doubleS1 = s1 + s1;
		return isSubString(doubleS1,s2);
		
		
	}
	
	boolean isSubString(String s1, String s2){
		return true;
	}
	
	public static void main(String[] args){
		Solution09 so = new Solution09();
		System.out.println(so.isRotation("waterbottle", "erbottlewat"));
		System.out.println(so.isRotation("waterbottle", "erbttlewat"));
	}
	
}
