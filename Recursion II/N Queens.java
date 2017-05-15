Using DFS
Base case: the last row is done. row == N
Recursive rule: if the position(i, j) is valid, go to the next row(i + 1)

Using the list to store current result.
Using check func to check the validality of assignment.


public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    if(n <= 0) {
      return res;
    }
    dfs(0, n, list, res);
    return res;
  }
  
  private void dfs(int row, int level, List<Integer> list, List<List<Integer>> res) {
    if(row == level) {
      res.add(new ArrayList<Integer>(list));
      return;
    }
    for(int i = 0; i < level; i++) {
      int size = list.size();
      if(check(list, i)) {
        list.add(i);
        dfs(row + 1, level, list, res);
        list.remove(size);
      }
    }
  }
  private boolean check(List<Integer> list, int pt) {
    int size = list.size();
    for(int i = 0; i < size; i++) {
      if(pt == list.get(i) || Math.abs(pt - list.get(i)) == size - i) {
        return false;
      }
    }
    return true;
  }
}
