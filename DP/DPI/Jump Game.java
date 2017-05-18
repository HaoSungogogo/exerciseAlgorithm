The difference from previous dp problem:

We need to fill in the table from end to the start!!!!

public class Solution {
  public boolean canJump(int[] array) {
    if(array == null || array.length <= 0) {
      return false;
    }
    if(array.length == 1) {
      return true;
    }
    boolean[] dp = new boolean[array.length];
    dp[array.length - 1] = true;
    for(int i = array.length - 2; i >= 0; i--) {
      int jump = array[i];
      for(int j = 0; j <= jump; j++) {
        if(dp[j + i] == true) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }
}