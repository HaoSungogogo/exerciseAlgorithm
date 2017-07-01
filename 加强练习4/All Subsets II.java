public class Solution {
  public List<String> subSets(String set) {
    List<String> list = new ArrayList<>();
    if (set == null) {
      return list;
    }
    char[] arr = set.toCharArray();
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    dfs(list, arr, sb, 0);
    return list;
  }
  private void dfs(List<String> list, char[] arr, StringBuilder sb, int level) {
    if (level == arr.length) {
      list.add(sb.toString());
      return;
    }
    sb.append(arr[level]);
    dfs(list, arr, sb, level + 1);
    sb.deleteCharAt(sb.length() - 1);
    while (level + 1 < arr.length && arr[level + 1] == arr[level]) {
      level++;
    }
    dfs(list, arr, sb, level + 1);
  }
}

Pruning way, directly go over duplicate element level. 
竖的 go over


public class Solution {
  public List<String> subSets(String set) {
    List<String> list = new ArrayList<>();
    if (set == null) {
      return list;
    }
    char[] arr = set.toCharArray();
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    dfs(list, arr, sb, 0);
    return list;
  }
  private void dfs(List<String> list, char[] arr, StringBuilder sb, int level) {
    list.add(sb.toString());
    for (int i = level; i < arr.length; i++) {
      sb.append(arr[i]);
      dfs(list, arr, sb, i + 1);
      sb.deleteCharAt(sb.length() - 1);
      while (i + 1 < arr.length && arr[i + 1] == arr[i]) {
        i++;
      }
    }
  }
}

横的 go over
k-nary tree.
