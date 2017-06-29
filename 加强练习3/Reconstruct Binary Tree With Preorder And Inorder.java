/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode reconstruct(int[] in, int[] pre) {
    Map<Integer, Integer> map = getMap(in);
    return reconstruct(in, 0, in.length - 1, pre, 0, pre.length - 1, map);
  }
  private TreeNode reconstruct(int[] in, int inStart, int inEnd, int[] pre, 
  int preStart, int preEnd, Map<Integer, Integer> map) {
    if (inStart > inEnd) {
      return null;
    }
    TreeNode cur = new TreeNode(pre[preStart]);
    int len = map.get(pre[preStart]) - inStart;
    cur.left = reconstruct(in, inStart, inStart + len - 1, pre, preStart + 1, preStart + len, map);
    cur.right = reconstruct(in, inStart + len + 1, inEnd, pre, preStart + len + 1, preEnd, map);
    return cur;
  }
  private Map<Integer, Integer> getMap(int[] in) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
    return map;
  }
}
