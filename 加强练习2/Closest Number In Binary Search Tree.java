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
  public int closest(TreeNode root, int target) {
    int res = root.key;
    while (root != null) {
      if (root.key == target) {
        return target;
      }
      if (Math.abs(res - target) > Math.abs(root.key - target)) {
        res = root.key;
      }
      if (root.key > target) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return res;
  }
}
