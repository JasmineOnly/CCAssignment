
public class Solution04 {
	
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,6,7};
		Listy list = new Listy(array);
		
		Solution04 s = new Solution04();
		System.out.println(s.search(list, 3));
	}
	
	public int search(Listy list, int value){
		int index = 1;
		
		// find the size of list by trying bigger and bigger values
		while(list.elementAt(index) != -1 && list.elementAt(index) < value ){
			index *= 2;
		}		
		return binarySearch(list, index/2, index, value);
	}
	
	public int binarySearch(Listy list, int left, int right, int value){
		if (left > right){
			return -1;
		}
		
		int mid = left + (right - left)/2;
		
		if (list.elementAt(mid) == value){
			return mid;
		}
		
		// If mid is out of the boundary, set the right boundary of search space as mid-1 
		if (mid == -1){
			return binarySearch(list, left, mid-1, value);
		}
		
		if (list.elementAt(mid) < value){
			return binarySearch(list, mid+1, right, value);
		}else if (list.elementAt(mid) > value){
			return binarySearch(list, left, mid-1, value);
		}
		
		return -1;
	}

}
