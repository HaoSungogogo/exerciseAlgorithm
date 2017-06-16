Recursion way:

public class Solution {
  public long fibonacci(int K) {
    if (K == 0) {
      return 0;
    } else if (K == 1) {
      return 1;
    }
    return fibonacci(K - 1) + fibonacci(K - 2);
  }
}

DP way with O(n) time complexity and O(n) space complexity:

public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0;
    }
    long[] dp = new long[K + 1];
    dp[1] = 1;
    for(int i = 2; i <= K; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[K];
  }
}

Trick: Only need one or two adjacent elements to get result, we do not need to store all the result. 

DP way with O(n) time complexity and O(1) space complexity:

public class Solution {
  public long fibonacci(int K) {
    long pre = 0;
    long cur = 1;
    if (K <= 0) {
      return pre;
    }
    for(int i = 1; i < K; i++) {
      long temp = cur;
      cur = cur + pre;
      pre = temp;
    } 
    return cur;
  }
}


