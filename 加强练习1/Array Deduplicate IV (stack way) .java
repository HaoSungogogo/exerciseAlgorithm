public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    int slow = 0;
    int fast = 1;
    while (fast < array.length) {
      if (slow == -1 || array[fast] != array[slow]) {
        array[++slow] = array[fast++];
      } else {
        while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
          fast++;
        }
        slow--;
        fast++;
      }
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
