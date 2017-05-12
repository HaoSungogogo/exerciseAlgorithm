// reverse process of merge sort


class Solution {
	public String reorderString(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		char[] arr = s.toCharArray();
		if(arr.length % 2 == 0) {
			reorder(arr, 0, arr.length - 1);
		}else {
			reorder(arr, 0, arr.length - 2);
		}
		return new String(arr);
	}
	private void reorder(char[] arr, int left, int right) {
		int size = right - left + 1;
		if(size <= 2) {
			return;
		}
		int mid = left + size / 2;
		int leftmid = left + size / 4;
		int rightmid = left + (size * 3) / 4;
		reverse(arr, leftmid, mid - 1);
		reverse(arr, mid, rightmid - 1);
		reverse(arr, leftmid, rightmid - 1);
		reorder(arr, left, left + 2 * (leftmid - left) - 1);
		reorder(arr, left + 2 * (leftmid - left), right);
	}
	private void reverse(char[] arr, int left, int right) {
		while(left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}