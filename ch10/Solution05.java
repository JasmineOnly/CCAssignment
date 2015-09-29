public class Solution05 {
	public static void main(String[] args){
		String[] s = {"at", "", "", "", "ball","","","car","","","dad","",""};
		Solution05 so = new Solution05();
		System.out.println(so.search(s, 0, s.length-1, "ball"));
		
	}
	public int search(String[] s, int left, int right, String target) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;

		

		if (s[mid].isEmpty()) {
			int head = mid - 1;
			int tail = mid + 1;

			while (s[mid].isEmpty()) {
				if (head < left && tail > right) {
					return -1;
				} else if (head >= left && !s[head].isEmpty()) {
					mid = head;
				} else if (tail <= right && !s[tail].isEmpty()) {
					mid = tail;
				}

				head--;
				tail++;
			}
		}
		
		if (s[mid].equals(target)) {
			return mid;
		}
		
		if (s[mid].compareTo(target) > 0) {
			return search(s, left, mid - 1, target);
		} else if (s[mid].compareTo(target) < 0) {
			return search(s, mid + 1, right, target);
		}
		
		return -1;

	}

}
