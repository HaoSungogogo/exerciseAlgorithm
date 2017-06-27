Same as spiral traverse -> 拨洋葱 determined by offset and size


public class Solution {
  public void rotate(int[][] matrix) {
    recursion(matrix, 0, matrix.length);
  }
  private void recursion(int[][] matrix, int offset, int size) {
    if (size <= 1) {
      return;
    }
    for (int i = 0; i < size - 1; i++) {
      int temp = matrix[offset][offset + i];
      matrix[offset][offset + i] = matrix[offset + size - 1 - i][offset];
      matrix[offset + size - 1 - i][offset] = matrix[offset + size - 1][offset + size - 1 - i];
      matrix[offset + size - 1][offset + size - 1 - i] = matrix[offset + i][offset + size - 1];
      matrix[offset + i][offset + size - 1] = temp;
    }
    recursion(matrix, offset + 1, size - 2);
  }
}
