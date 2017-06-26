public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      int counter = 0;
      while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
        fast++;
        counter++;
      }
      if (counter == 0) {
        array[slow++] = array[fast++];
      } else {
        fast++;
      }
    }
    return Arrays.copyOf(array, slow);
  }
}

Using counter to determine whether the element only appear once.