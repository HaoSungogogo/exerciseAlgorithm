
Solution 1: DP

public class Solution {
  public int longest(int[] array) {
    if(array == null || array.length == 0) {
      return 0;
    }
    int[] maxlen = new int[array.length];
    maxlen[0] = 1;
    for(int i = 1; i < array.length; i++) {
      if(array[i] > array[i - 1]) {
        maxlen[i] = maxlen[i - 1] + 1;
      }else {
        maxlen[i] = 1;
      }
    }
    int res = 0;
    for(int i : maxlen) {
      res = i > res? i : res;
    }
    return res;
  }
}


Solution 2: Sliding window. It is similar to the DP, only use O(1) to store subvalue.

public class Solution {
  public int longest(int[] array) {
    if(array == null || array.length == 0) {
      return 0;
    }
    int res = 0;
    int local = 0;
    for(int i = 0; i < array.length; i++) {
      if(i == 0 || array[i] > array[i - 1]) {
        res = Math.max(res, ++local);
      }else {
        local = 1; 
      }
    }
    return res;
  }
}
