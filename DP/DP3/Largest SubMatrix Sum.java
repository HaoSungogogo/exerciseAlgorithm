Integrate two basic ways: Path-Prefix sum, largest sum of SubArray
1: choose upper and lower bound of the row and caculate the Path-Prefix sum O(n^2)
2: In the one array, using largest sum of SubArray to get the result.


public class Solution {
  public int largest(int[][] matrix) {
    int col = matrix.length;
    int row = matrix[0].length;
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < col; i++) {
      int[] arr = new int[row];
      for(int j = i; j < col; j++) {
        add(arr, matrix[j]);
        res = Math.max(res, maxSubArray(arr));
      }
    }
    return res;
  }
  private void add(int[] arr, int[] matrix) {
    for(int i =0; i < arr.length; i++) {
      arr[i] += matrix[i];
    }
  }
  private int maxSubArray(int[] arr) {
    int max = arr[0];
    int local = arr[0];
    for(int i = 1; i < arr.length; i++) {
      if(local < 0) {
        local = arr[i];
      }else {
        local += arr[i];
      }
      max = Math.max(max, local);
    }
    return max;
  }
}
