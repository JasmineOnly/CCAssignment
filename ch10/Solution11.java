public class Solution11 {
	public static void main(String[] args){
		int[] input = {5,3,1,2,3};
		Solution11 s = new Solution11();
		s.peakValley(input);
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i] + " ");
		}
		
	}
	
	// sort an array into an alternating sequence of peeks and valleys
	public void peakValley(int[] array) {
		if (array.length == 1) {
			return;
		}
		if (array.length % 2 == 0) {
			for (int i = 1; i < array.length; i = i+2 ) {
				if (i == array.length - 1 && array[i] < array[i - 1]) {
					swap(array, i-1, i);
				}

				int maxIndex = getMax(array, i-1, i, i+1);
				if (maxIndex != i){
					swap(array, i, maxIndex);
				}
			}

		}else{
			for (int i = 1; i < array.length-1; i = i+2) {
				int maxIndex = getMax(array, i-1, i, i+1);
				if (maxIndex != i){
					swap(array, i, maxIndex);
				}
			}
		}
	}
	
	// swap two elements of the array
	public void swap(int[] array, int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	// Get the index of the maximum value
	public int getMax(int[] array, int a, int b, int c){
		int max = Math.max(array[a],Math.max(array[b], array[c]));
		if(max == array[a]){
			return a;
		}else if (max == array[b]){
			return b;
		}else{
			return c;
		}
	}
}
