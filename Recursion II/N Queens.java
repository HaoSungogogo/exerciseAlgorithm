Using DFS
Base case: the last row is done. row == N
Recursive rule: if the position(i, j) is valid, go to the next row(i + 1)

Using the list to store current result.
Using check func to check the validality of assignment.


public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> list = new ArrayList<>();
    if (n == 0) {
      return list;
    }
    List<Integer> cur = new ArrayList<>();
    dfs(list, cur, n);
    return list;
  }
  private void dfs(List<List<Integer>> list, List<Integer> cur, int n) {
    if (cur.size() == n) {
      list.add(new ArrayList(cur));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (check(cur, i)) {
        cur.add(i);
        dfs(list, cur, n);
        cur.remove(cur.size() - 1);
      }
    }
  }
  private boolean check(List<Integer> cur, int n) {
    for (int i = 0; i < cur.size(); i++) {
      if (cur.get(i) == n || Math.abs(cur.get(i) - n) == cur.size() - i) {
        return false;
      }
    }
    return true;
  }
}

