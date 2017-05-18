public class Solution {
  public int largest(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < dp.length; i++) {
      for(int j = 0; j< dp[0].length; j++) {
        if(i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
        }else if(matrix[i][j] == 0) {
          dp[i][j] = 0;
        }else {
          dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
        }
        res = Math.max(res, dp[i][j]);
      }
    }
    return res;
  }
}
