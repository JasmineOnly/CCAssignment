/*
 * Author: Yuanyuan Ma
 * Andrew ID: yuanyuam
 * 
 * Basic idea: Scan the matrix to mark the location of zeros; Then set the coordinating rows and columns zeros;
 *
 **/
public class Solution08 {
	public void setZeros(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i< matrix.length; i++){
			for(int j = 0; j< matrix[i].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j]= true;
					break;
				}									
			}
		}
		
		for (int i = 0; i< matrix.length; i++){
			if (row[i] == true){
				setRowZero(matrix, i);
			}			
		}
		
		for (int j = 0; j< matrix[0].length; j++){
			if (column[j] == true){
				setColumnZero(matrix, j );
			}
		}
		
	}
	
	public void setRowZero(int[][] matrix, int n){
		for(int i = 0; i< matrix[n].length; i++){
			matrix[n][i] = 0;
		}
	}
	
	public void setColumnZero(int[][] matrix, int n){
		for(int i = 0; i< matrix.length; i++){
			matrix[i][n] = 0;
		}
	}
	
	
	////////////// Test /////////////////
	public static void main(String[] args){
		Solution08 so = new Solution08();
		int[][] matrix = {{1,0,2,4},{4,5,7,8},{0,8,9,0},{2,4,6,7}};
		System.out.println("The original matrix: " );
		for(int i = 0; i< matrix.length; i++){
			for(int j = 0; j< matrix[i].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
			
		}
		so.setZeros(matrix);
		
		System.out.println("The edited matrix: ");
		
		for(int i = 0; i< matrix.length; i++){
			for(int j = 0; j< matrix[i].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
			
		}
		
		
	}
	

}
