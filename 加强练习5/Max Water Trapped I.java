public class Solution {
  public int maxTrapped(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int[] dp1 = new int[array.length];
    int[] dp2 = new int[array.length];
    dp1[0] = 0;
    for (int i = 1; i < array.length; i++) {
      dp1[i] = Math.max(dp1[i - 1], array[i - 1]);
    }
    dp2[array.length - 1] = 0;
    for (int i = array.length - 2; i >= 0; i--) {
      dp2[i] = Math.max(dp2[i + 1], array[i + 1]);
    }
    int res = 0;
    for (int i = 0; i < array.length; i++) {
      int height = Math.min(dp1[i], dp2[i]);
      if (height > array[i]) {
        res += height - array[i];
      }
    }
    return res;
  }
}

DP way



public class Solution {
  public int maxTrapped(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    int i = 0;
    int j = array.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int res = 0;
    while (i < j) {
      leftMax = Math.max(leftMax, array[i]);
      rightMax = Math.max(rightMax, array[j]);
      if (leftMax <= rightMax) {
        res += leftMax - array[i];
        i++;
      } else {
        res += rightMax - array[j];
        j--;
      }
    }
    return res;
  }
}


Optimized way -> only care about the min of leftMax and rightMax