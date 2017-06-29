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
  public int maxPathSum(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    maxPathSum(root, max);
    return max[0];
  }
  private int maxPathSum(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int left = maxPathSum(root.left, max);
    int right = maxPathSum(root.right, max);
    if (root.left != null && root.right != null) {
      max[0] = Math.max(max[0], left + right + root.key);
    }
    if (root.left == null) {
      return right + root.key;
    } else if (root.right == null) {
      return left + root.key;
    } else {
      return root.key + Math.max(left, right);
    }
  }
}

Similar to largest sub-array -> < 0 discard.