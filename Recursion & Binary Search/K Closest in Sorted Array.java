public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0) {
      return array;
    }
    int[] res = new int[k];
    int right = smallestLargeOrEqual(array, target);
    int left = right - 1;
    int i = 0;
    while(i < k) {
      if(left < 0 || ((right <= array.length - 1) && (array[right] - target < target - array[left]))) {
        res[i++] = array[right++];
      } else {
        res[i++] = array[left--]; 
      }
    }
    return res;
  }
  private int smallestLargeOrEqual (int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while(left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] >= target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if(array[left] >= target) {
      return left;
    } else if (array[right] >= target) {
      return right;
    }else {
      return array.length;
    }
  }
}
