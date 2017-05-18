Recursion way:

public class Solution {
  public int maxProduct(int length) {
    if(length <= 1) {
      return -1;
    }
    int res = 0;
    for(int i = 1; i < length; i++) {
      int temp = Math.max(length - i, maxProduct(length - i));
      res = Math.max(res, temp * i);
    }
    return res;
  }
}


DP:
左大段，右小段：
public class Solution {
  public int maxProduct(int length) {
    int[] res = new int[length + 1];
    int max = 0;
    res[0] = 0;
    res[1] = 0;
    for(int i = 2; i < res.length; i++) {
      for(int j = 1; j < i; j++) {
        int temp = Math.max(i - j, res[i - j]);
        res[i] = Math.max(res[i], temp * j);
      }
    }
    for(int i : res) {
      max = i > max? i : max;
    }
    return max;
  }
}

左大段，右大段：

public class Solution {
  public int maxProduct(int length) {
    int[] res = new int[length + 1];
    res[0] = 0;
    res[1] = 0;
    for(int i = 2; i < res.length; i++) {
      for(int j = 1; j <= i / 2; j++) {
        int left = Math.max(j, res[j]);
        int right = Math.max(i - j, res[i - j]);
        res[i] = Math.max(res[i], left * right);
      }
    }
    return res[length];
  }
}
