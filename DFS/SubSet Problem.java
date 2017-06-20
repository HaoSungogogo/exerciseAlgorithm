public class Solution {
  public List<String> subSets(String set) {
    List<String> list = new ArrayList<>();
    if (set == null) {
      return list;
    }
    StringBuilder sb = new StringBuilder();
    dfs(set, sb, list, 0);
    return list;
  }
  private void dfs(String set, StringBuilder sb, List<String> list, int level) {
    if (level == set.length()) {
      list.add(sb.toString());
      return;
    }
    dfs(set, sb, list, level + 1);
    dfs(set, sb.append(set.charAt(level)), list, level + 1);
    sb.deleteCharAt(sb.length() - 1);
  }
}


The K-branches tree method:

public class Solution {
  public List<String> subSets(String set) {
    List<String> list = new ArrayList<>();
    if (set == null) {
      return list;
    }
    StringBuilder sb = new StringBuilder();
    dfs(set, sb, list, 0);
    return list;
  }
  private void dfs(String set, StringBuilder sb, List<String> list, int level) {
    list.add(sb.toString());
    for (int i = level; i < set.length(); i++) {
      sb.append(set.charAt(i));
      dfs(set, sb, list, i + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
