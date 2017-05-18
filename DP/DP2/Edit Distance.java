Two Dimensional DP

public class Solution {
  public int editDistance(String one, String two) {
    int[][] dp = new int[one.length() + 1][two.length() + 1];
    for(int i = 0; i< dp.length; i++) {
      for(int j = 0; j < dp[0].length; j++) {
        if(i == 0) {
          dp[i][j] = j;
        }else if(j == 0) {
          dp[i][j] = i;
        }else if(one.charAt(i - 1) == two.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        }else {
          dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
          dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
        }
      }
    }
    return dp[one.length()][two.length()];
  }
}