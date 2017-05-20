

public class Solution {
  public int longest(int[] array) {
    if(array == null || array.length <= 0) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int[] dp = new int[array.length];
    for(int i = 0; i < array.length; i++) {
      if(i == 0 || array[i] == 0) {
        dp[i] = array[i];
      }else {
        dp[i] = dp[i - 1] + 1;
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}



Another way: we only check the element is 1. No need to check the element is 0.