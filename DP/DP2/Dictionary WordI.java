Using 左大段，右小段（only using）
The reason why we using length + 1 array:
1. easy to use substring(0, i)
2. easy to use dp[0], when we substring all the element.

public class Solution {
  public boolean canBreak(String input, String[] dict) {
    Set<String> set = toSet(dict);
    boolean[] dp = new boolean[input.length() + 1];
    dp[0] = true;
    dp[1] = set.contains(input.substring(0, 1));
    for(int i = 2; i < dp.length; i++) {
       for(int j = 0; j <= i ; j++) {
	        dp[i] = dp[i] || (set.contains(input.substring(j, i)) && dp[j]);
        if(dp[i]) {
          break;
        }
      }
    }
     return dp[dp.length - 1];
  }
  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for(String s : dict) {
      set.add(s);
    }
    return set;
  }
}
