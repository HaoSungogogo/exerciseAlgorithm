中心开花！！

public class Solution {
  public int minCost(int[] cuts, int length) {
    int[] arr = new int[cuts.length + 2];
    arr[0] = 0;
    arr[arr.length - 1] = length;
    for (int i = 0; i < cuts.length; i++) {
      arr[i + 1] = cuts[i];
    }
    int[][] m = new int[arr.length][arr.length];
    for (int i = 1; i < arr.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (i - j == 1) {
          m[j][i] = 0;
        } else {
          m[j][i] = Integer.MAX_VALUE;
          for (int k = j + 1; k <= i - 1; k++) {
            m[j][i] = Math.min(m[j][i], m[j][k] + m[k][i]);
          }
          m[j][i] += arr[i] - arr[j];
        }
      }
    }
    return m[0][arr.length - 1];
  }
}
