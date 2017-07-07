public class Solution {
  public int majority(int[] array) {
    int cur = array[0];
    int count = 1;
    for (int i = 1; i < array.length; i++) {
      if (count > 0) {
        if (array[i] != cur) {
          count--; 
        } else {
          count++;
        }
      } else {
        cur = array[i];
        count++;
      }
    }
    return cur;
  }
}
