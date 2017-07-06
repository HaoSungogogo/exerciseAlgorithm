public class Solution {
  public int maxTrapped(int[][] matrix) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    int row = matrix.length;
    int col = matrix[0].length;
    if (row < 3 || col < 3) {
      return 0;
    }
    boolean[][] visited = new boolean[row][col];
    processBorder(pq, visited, matrix, row, col);
    int res = 0;
    while (!pq.isEmpty()) {
      Pair cur = pq.poll();
      List<Pair> nei = getNei(cur, matrix);
      for (Pair iter : nei) {
        if (visited[iter.i][iter.j]) {
          continue;
        }
        visited[iter.i][iter.j] = true;
        if (iter.height < cur.height) {
          res += cur.height - iter.height;
        }
        iter.height = Math.max(cur.height, iter.height);
        pq.offer(iter);
      }
    }
    return res;
  }
  private void processBorder (PriorityQueue<Pair> pq, boolean[][] visited, 
  int[][] matrix, int row, int col) {
    for (int j = 0; j < col; j++) {
      pq.offer(new Pair(0, j, matrix[0][j]));
      pq.offer(new Pair(row - 1, j, matrix[row - 1][j]));
      visited[0][j] = true;
      visited[row - 1][j] = true;
    }
    for (int i = 1; i < row - 1; i++) {
      pq.offer(new Pair(i, 0, matrix[i][0]));
      pq.offer(new Pair(i, col - 1, matrix[i][col - 1]));
      visited[i][0] = true;
      visited[i][col - 1] = true;
    }
  }
  
  private List<Pair> getNei (Pair cur, int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    List<Pair> nei = new ArrayList<>();
    if (cur.i + 1 < row) {
      nei.add(new Pair(cur.i + 1, cur.j, matrix[cur.i + 1][cur.j]));
    }
    if (cur.j + 1 < col) {
      nei.add(new Pair(cur.i, cur.j + 1, matrix[cur.i][cur.j + 1]));
    }
    if (cur.i - 1 >= 0) {
      nei.add(new Pair(cur.i - 1, cur.j, matrix[cur.i - 1][cur.j]));
    }
    if (cur.j - 1 >= 0) {
      nei.add(new Pair(cur.i, cur.j - 1, matrix[cur.i][cur.j - 1]));
    }
    return nei;
  }
  
  class Pair implements Comparable<Pair> {
    int i;
    int j;
    int height;
    public Pair (int i, int j, int height) {
      this.i = i;
      this.j = j;
      this.height = height;
    }
    //override
    public int compareTo(Pair p) {
      if (this.height == p.height) {
        return 0;
      }
      return this.height < p.height ? -1 : 1;
    }
  }
}
