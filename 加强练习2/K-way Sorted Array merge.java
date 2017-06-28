public class Solution {
  public int[] merge(int[][] arrayOfArrays) {
    PriorityQueue<Cell> pq = new PriorityQueue(11, new Comparator<Cell>() {
      public int compare(Cell o1, Cell o2) {
        if (o1.val == o2.val) {
          return 0;
        }
        return o1.val < o2.val ? -1 : 1;
      }
    });
    int len = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      len += arrayOfArrays[i].length;
      if (arrayOfArrays[i].length != 0) {
         pq.offer(new Cell(i, 0, arrayOfArrays[i][0]));
      }
    }
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      Cell temp = pq.poll();
      res[i] = temp.val;
      if (temp.col + 1 < arrayOfArrays[temp.row].length) {
        pq.offer(new Cell(temp.row, temp.col + 1, arrayOfArrays[temp.row][temp.col + 1]));
      }
    }
    return res;
  }
  class Cell {
    public int row;
    public int col;
    public int val;
    public Cell(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }
}
