public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    int res = 0;
    int[] dp = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (array[j] < array[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      res = Math.max(res, dp[i]);
    }
    return res;
  }
}
O(n^2)

Optimize way -> binary search way.

public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    int[] res = new int[array.length];
    res[0] = array[0];
    int right = 0;
    for (int i = 1; i < array.length; i++) {
      int index = smallestEqualOrLarger(array, res, 0, right, array[i]);
      if (index == -1) {
        res[++right] = array[i];
      } else {
        res[index] = array[i];
      }
    }
    return right + 1;
  }
  private int smallestEqualOrLarger(int[] array, int[] res, int left, int right, int target) {
    if (res[right] < target) {
      return -1;
    }
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (target <= array[mid]) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (target <= array[left]) {
      return left;
    } else {
      return right;
    }
  }
}
