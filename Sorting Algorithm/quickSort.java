public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int index = partition(array, left, right);
    quickSort(array, left, index - 1);
    quickSort(array, index + 1, right);
  }
  private int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int start = left;
    int end = right - 1;
    while (start <= end) {
      if (array[start] < pivot) {
        start++;
      } else if (array[end] > pivot) {
        end--;
      } else {
        swap(array, start++, end--);
      }
    }
    swap(array, start, right);
    return start;
  }
  private void swap(int[] array, int left, int right) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}