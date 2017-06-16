public class Solution {
  public int closest(int[] array, int target) {
    if(array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;

    // stop in advance
    
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }

    // post processing

    if(Math.abs(target - array[left]) > Math.abs(target - array[right])) {
      return right;
    } else {
      return left;
    }
  }
}
