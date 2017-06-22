reverse process of merge sort


public class Solution {
  public int[] reorder(int[] array) {
    if (array.length % 2 == 0) {
      reOrder(array, 0, array.length - 1);
    } else {
      reOrder(array, 0, array.length -2);
    }
    return array;
  }
  private void reOrder(int[] array, int left, int right) {
    if (right - left <= 2) {
      return;
    }
    int size = right - left + 1;
    int mid = left + size / 2;
    int leftmid = left + size / 4;
    int rightmid = left + size * 3 / 4;
    reverse(array, leftmid, rightmid - 1);
    reverse(array, leftmid,  mid - 1);
    reverse(array, mid, rightmid - 1);
    reOrder(array, left, left + (leftmid - left) * 2 - 1);
    reOrder(array, left + (leftmid - left) * 2, right);
  }
  private void reverse(int[] array, int left, int right) {
    while (left < right) {
      int temp = array[left];
      array[left] = array[right];
      array[right] = temp;
      left++;
      right--;
    }
  }
}
