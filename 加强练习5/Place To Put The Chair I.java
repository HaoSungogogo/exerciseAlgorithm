public class Solution {
  public List<Integer> putChair(char[][] gym) {
    int row = gym.length;
    int col = gym[0].length;
    int[][] cost = new int[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (gym[i][j] == 'E') {
          addCost(gym, cost, i, j);
        }
      }
    }
    List<Integer> result = null;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (gym[i][j] != 'O' && gym[i][j] != 'E') {
          if (result == null) {
            result = Arrays.asList(i, j);
          } else {
            if (cost[i][j] < cost[result.get(0)][result.get(1)]) {
              result = Arrays.asList(i, j);
            }
          }
        }
      }
    }
    return result;
  }
  private void addCost(char[][] gym, int[][] cost, int i, int j) {
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    int pathWeight = 1;
    Queue<Pair> qu = new LinkedList<>();
    qu.offer(new Pair(i, j));
    visited[i][j] = true;
    while (!qu.isEmpty()) {
      int size = qu.size();
      for (int k = 0; k < size; k++) {
        Pair cur = qu.poll();
        List<Pair> nei = getNei(cur, gym);
        for (Pair iter : nei) {
          if (!visited[iter.i][iter.j]) {
            cost[iter.i][iter.j] += pathWeight;
            visited[iter.i][iter.j] = true;
            qu.offer(iter);
          }
        }
      }
      pathWeight++;
    }
  }
  private List<Pair> getNei (Pair cur, char[][] gym) {
    int row = gym.length;
    int col = gym[0].length;
    List<Pair> list = new ArrayList<>();
    if (cur.i + 1 < row && gym[cur.i + 1][cur.j] != 'O') {
      list.add(new Pair(cur.i + 1, cur.j));
    }
    if (cur.j + 1 < col && gym[cur.i][cur.j + 1] != 'O') {
      list.add(new Pair(cur.i, cur.j + 1));
    }
    if (cur.i - 1 >= 0 && gym[cur.i - 1][cur.j] != 'O') {
      list.add(new Pair(cur.i - 1, cur.j));
    }
    if (cur.j - 1 >= 0 && gym[cur.i][cur.j - 1] != 'O') {
      list.add(new Pair(cur.i, cur.j - 1));
    }
    return list;
  }
  
  class Pair {
    int i;
    int j;
    public Pair (int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}
