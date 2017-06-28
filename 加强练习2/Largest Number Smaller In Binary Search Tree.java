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
  public int largestSmaller(TreeNode root, int target) {
    int res = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key < target) {
        if (res == Integer.MIN_VALUE || target - root.key < target - res) {
          res = root.key;
        }
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return res;
  }
}
