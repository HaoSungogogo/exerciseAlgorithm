public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 2) {
      return array;
    }
    int slow = 2;
    int fast = 2;
    while (fast < array.length) {
      if (array[fast] == array[slow - 2]) {
        fast++;
      } else {
        array[slow++] = array[fast++];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
