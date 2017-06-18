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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> list = new ArrayList<>();
    recursion(root, min, max, list);
    return list;
  }
  private void recursion(TreeNode root, int min, int max, List<Integer> list) {
    if (root == null) {
      return;
    }
    if (root.key > min) {
      recursion(root.left, min, max, list);
    }
    if (root.key <= max && root.key >= min) {
      list.add(root.key);
    }
    if (root.key < max) {
      recursion(root.right, min, max, list);
    }
  }
}
