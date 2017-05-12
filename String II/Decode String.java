// No matter decode or encode, we have to consider two cases:
// 1. to make the char[] short 2. to make the char[] long.
// we need to handle two cases respecitively. 
// Usually, tackle short one is kind of easy, just using fast and slow pointer.
// For the long case, we need to resize the array, and create new one , then traverse from the end of array.


class Solution {
	public String decompress(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		char[] arr = s.toCharArray();
		int lenshort = decodeShort(arr);
		return decodeLong(arr, lenshort);
	}
	private int getDigit(char chr) {
		return chr - '0';
	}
	private int decodeShort(char[] arr) {
		int slow = 0;
		for(int i = 0; i < arr.length; i += 2) {
			int digit = getDigit(arr[i + 1]);
			if(digit >= 0 && digit <= 2) {
				for(int j = 0; j < digit; j++) {
					arr[slow++] = arr[i];
				}
			}else {
				arr[slow++] = arr[i];
				arr[slow++] = arr[i + 1];
			}
		}
		return slow;
	}
	private String decodeLong(char[] arr, int len) {
		int newlen = len;
		for(int i = 0; i < len; i++) {
			int digit = getDigit(arr[i]);
			if(digit > 2 && digit <= 9) {
				newlen += digit - 2;
			}
		}
		char[] res = new char[newlen];
		int slow = newlen - 1;
		for(int j = len - 1; j >= 0; j--) {
			int digit = getDigit(arr[j]);
			if(digit > 2 && digit <= 9) {
				j--;
				for(int k = 0; k < digit; k++) {
					res[slow--] = arr[j];
				}
			}else {
				res[slow--] = arr[j];
			}
		}
		return new String(res);
	}
}