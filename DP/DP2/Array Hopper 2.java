We must pay attention hop out of bound.



public class Solution {
  public int minJump(int[] array) {
    if(array == null || array.length <= 0) {
      return -1;
    }
    if(array.length == 1) {
      return 0;
    }
    int[] dp = new int[array.length];
    dp[array.length - 1] = 0;
    for(int i = array.length - 2; i >= 0; i--) {
      int jump = array[i];
      int min = Integer.MAX_VALUE;
      if(i + jump >= array.length) {
        dp[i] = 1;
        continue;
      }
      for(int j = 1; j <= jump; j++) {
        min = Math.min(dp[i + j], min);
      }
      if(min == Integer.MAX_VALUE) {
        dp[i] = min;
      }else {
        dp[i] = 1 + min;
      }
    }
    return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
  }
}