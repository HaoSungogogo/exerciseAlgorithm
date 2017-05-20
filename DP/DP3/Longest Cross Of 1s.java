Extending the longest consecutive 1s, from the four direction to use, and merge with MIN



public class Solution {
  public int largest(int[][] matrix) {
    int col = matrix.length;
    if (col == 0) {
      return 0;
   }
    int row = matrix[0].length;
    if(row == 0) {
      return 0;
    }
    int[][] leftup = leftUp(matrix, col, row);
    int[][] rightdown = rightDown(matrix, col, row);
    return merge(leftup, rightdown, col, row);
  }
  private int merge(int[][] one, int[][] two, int col, int row) {
    int max = 0;
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        one[i][j] = Math.min(one[i][j], two[i][j]);
        max = Math.max(max, one[i][j]);
      }
    }
    return max;
  }
  private int[][] leftUp(int[][] matrix, int col, int row) {
    int[][] left = new int[col][row];
    int[][] up = new int[col][row]; 
    for(int i = 0; i < col; i++) {
      for(int j = 0; j < row; j++) {
        if(matrix[i][j] == 1) {
          if(i == 0 && j == 0) {
            left[i][j] = 1;
            up[i][j] = 1;
          }else if(i == 0) {
            left[i][j] = left[i][j - 1] + 1;
            up[i][j] = 1;
          }else if(j == 0) {
            left[i][j] = 1;
            up[i][j] = up[i - 1][j] + 1;
          }else {
            left[i][j] = left[i][j - 1] + 1;
            up[i][j] = up[i - 1][j] + 1;
          }
        }
      }
    }
    merge(left, up, col, row);
    return left;
  }
  private int[][] rightDown(int[][] matrix, int col, int row) {
    int[][] right = new int[col][row];
    int[][] down = new int[col][row];
    for(int i = col - 1; i >= 1; i--) {
      for(int j = row - 1; j >= 1; j--) {
        if(matrix[i][j] == 1) {
          if(i == col - 1 && j == row - 1) {
            right[i][j] = 1;
            down[i][j] = 1;
          }else if(i == col - 1) {
            right[i][j] = right[i][j + 1] + 1;
            down[i][j] = 1;
          }else if(j == row - 1) {
            right[i][j] = 1;
            down[i][j] = down[i + 1][j] + 1;
          }else {
            right[i][j] = right[i][j + 1] + 1;
            down[i][j] = down[i + 1][j] + 1;
          }
        }
      }
    }
    merge(right, down, col, row);
    return right;
  }
}
