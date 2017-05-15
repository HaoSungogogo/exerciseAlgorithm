Recursively to output, add two parameter to recurse
1: size of current sub matrix
2: the offset of the current sub


public class Solution {
  public List<Integer> spiral(int[][] matrix) {
     List<Integer> list = new ArrayList<Integer>();
     if(matrix == null || matrix.length == 0) {
       return list;
     }
     int size = matrix.length;
     recurse(matrix, list, 0, size);
     return list;
  }
  private void recurse(int[][] matrix, List<Integer> list, int offset, int size) {

    // two possible base case!!!!!!!!
    if(size == 0) {
      return;
    }
    if(size == 1) {
      list.add(matrix[offset][offset]);
      return;
    }
    for(int i = 0; i < size - 1; i++) {
      int temp = matrix[offset][i + offset];
      list.add(temp);
    }
    for(int i = 0; i < size - 1; i++) {
      int temp = matrix[i + offset][offset + size - 1];
      list.add(temp);
    }
    for(int i = size - 1; i >= 1; i--) {
      int temp = matrix[offset + size - 1][offset + i];
      list.add(temp);
    }
    for(int i = size - 1; i>= 1; i--) {
      int temp = matrix[offset + i][offset];
      list.add(temp);
    }
    recurse(matrix, list, offset + 1, size - 2);
  }
}
