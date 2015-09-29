public class Solution03 {
	public static void main(String[] args) {
		int[] a = { 2, 4, 2, 2, 2, 2 };
		Solution03 s = new Solution03();
		int index = s.search(a, 4);
		System.out.println(index);

	}

	public int search(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);

	}

	public int binarySearch(int[] nums, int left, int right, int target) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;

		if (nums[mid] == target) {
			return mid;
		}

		if (nums[left] < nums[mid]) {
			if (nums[left] <= target && target < nums[mid]) {
				return binarySearch(nums, left, mid - 1, target);

			} else {
				return binarySearch(nums, mid + 1, right, target);

			}
		} else if (nums[mid] < nums[right]) {
			if (nums[mid] < target && target <= nums[right]) {
				return binarySearch(nums, mid + 1, right, target);
			} else {
				return binarySearch(nums, left, mid - 1, target);
			}
		} else if (nums[left] == nums[mid]) {
			if (nums[right] != nums[mid]) {
				return binarySearch(nums, mid + 1, right, target);
			} else {
				int result = binarySearch(nums, left, mid - 1, target);
				if (result == -1) {
					return binarySearch(nums, mid + 1, right, target);
				}
				return result;
			}
		}
		return -1;
	}

}
