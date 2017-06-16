Binary step !!

Time complexity: O(logb)
Space complexity: O(logb)

public class Solution {
  public long power(int a, int b) {
    if (b == 0) {
      return 1;
    }
    long half = power(a, b / 2);
    if (b % 2 == 0) {
      return half * half;
    } else {
      return half * half * a;
    }
  }
}

Time complexity is : O(logn)
Space complexity is : O(logn)
