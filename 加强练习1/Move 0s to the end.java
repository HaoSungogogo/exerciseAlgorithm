Same direction, two pointer, maintain the relative order.

public class Solution {
  public int[] moveZero(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      if (array[fast] != 0) {
        array[slow++] = array[fast++];
      } else {
        fast++;
      }
    }
    while (slow < array.length) {
      array[slow++] = 0;
    }
    return array;
  }
}

Rainbow Sort, two pointer with different directions, do not maintain the relative order.

public class Solution {
  public int[] moveZero(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      if (array[start] != 0) {
        start++;
      } else if (array[end] == 0) {
        end--;
      } else {
        swap(array, start, end);
        start++;
        end--;
      }
    }
    return array;
  }
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}