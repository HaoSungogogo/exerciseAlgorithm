Usually as helper function.
To get the largest subarray sum

Not Using array to store subproblem value!!!
Using local to store the last result of subproblem!!!

public class Solution {
  public int largestSum(int[] array) {
     int max = Integer.MIN_VALUE;
     int local = 0;
     if(array == null || array.length <= 0) {
       return -1;
     }
     for(int i = 0; i < array.length; i++) {
       if(local < 0) {
         local = array[i];
       }else {
         local += array[i];
       }
       max = Math.max(max, local);
     }
     return max;
  }
}
