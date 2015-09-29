
public class Solution09 {
	public static void main(String[] args){
		int[][] matrix = { {15,20,70,85},{20,35,80,95},{30,55,95,105},{40,80,100,120}};
		Solution09 s = new Solution09();
		int[] result = s.searchMatrix(matrix, 80);
		for(int i = 0; i < 2; i++){
			System.out.print(result[i] + " ");
		}
	}
	public int[]searchMatrix(int[][] matrix, int target){
		// Search the element starting from the top right corner
		int r = 0;
		int c = matrix[0].length -1;
		
		int[] result = new int[2];
		while(r < matrix.length && c > 0 ){
			if (matrix[r][c] == target){
				result[0] = r;
				result[1] = c;
				return result;
			}else if (matrix[r][c] > target){
				c--;
			}else{
				r++;
			}
		}
		return result;		
	}
}
