/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Rotate the matrix by edge swap: left -> top -> right -> bottom
 * 
 **/
public class Solution07 {
	
	public void rotateMatrix(int[][] matrix, int n){
		int temp = 0;
		for(int i = 0; i< n/2; i++){
			for(int j = i; j< n-1; j++){
				int top = matrix[i][j];
				temp = top;
				int left = matrix[n-1-j][i];
				matrix[i][j] = left;
				int bottom = matrix[n-1-i][n-1-j];
				matrix[n-1-j][i] = bottom;
				int right = matrix[j][n-1-i];
				matrix[n-1-i][n-1-j] = right;
				matrix[j][n-1-i] = top;
				
			}
			
		}
		
	}
	
	

}
