The way is the same as longest cross of 1s. 
When dp, the corner case of four directions is the same, so we abstract it as helper function(getNumber())

public class Solution {
  public int largest(int[][] matrix) {
    int col = matrix.length;
    if(col == 0) {
      return 0;
    }
    int row = matrix[0].length;
    if(row == 0) {
      return 0;
    }
    int[][] leftup = leftUp(matrix, col, row);
    int[][] rightdown = rightDown(matrix, col, row);
    return merge(leftup, rightdown, col ,row);
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
          left[i][j] = getNumber(left, i - 1, j - 1, col, row) + 1;
          up[i][j] = getNumber(up, i - 1, j + 1, col, row) + 1;
        }
      }
    }
    merge(left, up, col, row);
    return left;
  }
  private int[][] rightDown(int[][]matrix, int col, int row) {
    int[][] right = new int[col][row];
    int[][] down = new int[col][row];
    for(int i = col - 1; i >= 0; i--) {
      for(int j = row - 1; j >= 0; j--) {
        if(matrix[i][j] == 1) {
          right[i][j] = getNumber(right, i + 1, j + 1, col, row) + 1;
          down[i][j] = getNumber(down, i + 1, j - 1, col, row) + 1;
        }
      }
    }
    merge(right, down, col, row);
    return right;
  }
  private int getNumber(int[][] matrix, int i, int j, int col, int row) {
    if(i < 0 || i >= col || j < 0 || j >= row) {
      return 0;
    }
    return matrix[i][j];
  }
}
