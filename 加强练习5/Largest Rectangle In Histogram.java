public class Solution {
  public int largest(int[] array) {
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      int left = i;
      while (left - 1 >= 0) {
        if (array[left - 1] >= array[i]) {
          left--;
        } else {
          break;
        }
      }
      int right = i;
      while (right + 1 < array.length) {
        if (array[right + 1] >= array[i]) {
          right++;
        } else {
          break;
        }
      }
      right = right + 1;
      max = Math.max(max, (right - left) * array[i]);
    }
    return max;
  }
}


单调栈

public class Solution {
  public int largest(int[] array) {
    int res = 0;
    Deque<Integer> stack = new LinkedList<>();
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        res = Math.max(res, height * (i - left));
      }
      stack.offerFirst(i);
    }
    return res;
  }
}
