public class Solution {
  private static final char[] PS = new char[]{'(', ')', '[', ']', '{', '}'};
  public List<String> validParentheses(int l, int m, int n) {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int targetLevel = 2 * (l + m + n);
    int[] remain = new int[]{l, l, m, m, n, n};
    Deque<Character> stack = new LinkedList<>();
    dfs(list, sb, remain, stack, targetLevel);
    return list;
  }
  private void dfs(List<String> list, StringBuilder sb, int[] remain, Deque<Character> stack,
  int targetLevel) {
    if (sb.length() == targetLevel) {
      list.add(sb.toString());
      return;
    }
    for (int i = 0; i < remain.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
          remain[i]--;
          sb.append(PS[i]);
          stack.offerFirst(PS[i]);
          dfs(list, sb, remain, stack, targetLevel);
          remain[i]++;
          sb.deleteCharAt(sb.length() - 1);
          stack.pollFirst();
        }
      } else {
        if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
          remain[i]--;
          sb.append(PS[i]);
          stack.pollFirst();
          dfs(list, sb, remain, stack, targetLevel);
          remain[i]++;
          sb.deleteCharAt(sb.length() - 1);
          stack.offerFirst(PS[i - 1]);
        }
      }
    }
  }
}

括号相当于查询表 － 做成final array。
多个参数，放成一个array一起管理

levels = 2 * (m + n + l)
states = the number of types of parentheses