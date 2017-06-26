Normal Duplication:

public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    int slow = 1;
    int fast = 1;
    while (fast < array.length) {
      if (array[fast] == array[slow - 1]) {
        fast++;
      } else {
        array[slow++] = array[fast++];
      }
    }
    return Arrays.copyOf(array, slow);
  }
}
