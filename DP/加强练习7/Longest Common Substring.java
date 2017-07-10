public class Solution {
  public String longestCommon(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return new String();
    }
    char[] arrs = s.toCharArray();
    char[] arrt = t.toCharArray();
    int[][] dp = new int[s.length()][t.length()];
    int longest = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          if (i == 0 || j == 0) {
            dp[i][j] = 1;
          } else {
           dp[i][j] = 1 + dp[i - 1][j - 1]; 
          }
          if (dp[i][j] > longest) {
            longest = dp[i][j];
            end = i;
          }
        }
      }
    }
    return s.substring(end - longest + 1, end + 1);
  }
}
