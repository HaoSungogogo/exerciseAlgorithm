public class Solution {
  public int[] search(int[][] matrix, int target) {
   if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
     return new int[] {-1, -1};
   }
   int row = matrix.length;
   int col = matrix[0].length;
   int left = 0;
   int right = row * col - 1;
   while(left <= right) {
     int mid = left + (right - left) / 2;
     int midcol = mid / col;
     int midrow = mid % col;
     if (matrix[midcol][midrow] == target) {
       return new int[] {midcol, midrow};
     } else if (matrix[midcol][midrow] < target) {
       left = mid + 1;
     } else {
       right = mid - 1;
     }
   }
   return new int[] {-1, -1};
  }
}


Convert the 2D matrix into 1D array, so the index range is from 0 to (col * row - 1)
Reconfigure the 2D matrix by using: 
                            midcol = index / col;
                            midrow = index % col;