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
  public TreeNode reconstruct(int[] post) {
    List<Integer> list = new ArrayList<>();
    for (int i : post) {
      list.add(i);
    }
    return reconstruct(list);
  }
  private TreeNode reconstruct(List<Integer> list) {
    if (list.isEmpty()) {
      return null;
    }
    int cur = list.get(list.size() - 1);
    TreeNode root = new TreeNode(cur);
    List<Integer> llist = new ArrayList<>();
    List<Integer> rlist = new ArrayList<>();
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) < cur) {
        llist.add(list.get(i));
      } else {
        rlist.add(list.get(i));
      }
    }
    root.left = reconstruct(llist);
    root.right = reconstruct(rlist);
    return root;
  }
}
