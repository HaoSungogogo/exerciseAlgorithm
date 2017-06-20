public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> cur = new ArrayList<Integer>();
    dfs(list, cur, 0, coins, target);
    return list;
  }
  
  private void dfs(List<List<Integer>> list, List<Integer> cur, int level, int[] coins, int target){
    if (level == coins.length - 1) {
      if (target % coins[level] == 0) {
        cur.add(target / coins[level]);
        list.add(new ArrayList<Integer>(cur));
        cur.remove(level);
      }
      return;
    }
    int num = target / coins[level];
    for (int i = 0; i <= num; i++) {
      cur.add(i);
      dfs(list, cur, level + 1, coins, target - coins[level] * i);
      cur.remove(level);
    }
  }
}


n - branches tree dfs.