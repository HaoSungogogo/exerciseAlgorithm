public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int row = matrix.length;
    int col = matrix[0].length;
    boolean[][] visited = new boolean[row][col];
    PriorityQueue<Cell> pq = new PriorityQueue<>(k,
    new Comparator<Cell>() {
      public int compare(Cell o1, Cell o2) {
        if (o1.val == o2.val) {
          return 0;
        }
        return o1.val < o2.val ? -1 : 1;
      }
    });
    pq.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    for (int i = 0; i < k - 1; i++) {
      Cell cur = pq.poll();
      if (cur.row + 1 < row && !visited[cur.row + 1][cur.col]) {
        pq.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < col && !visited[cur.row][cur.col + 1]) {
        pq.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return pq.peek().val;
  }
  class Cell {
    public int row;
    public int col;
    public int val;
    public Cell (int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }
}


Time Complexity: O(klogk)