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
    int left = maxPathSum(root.left, max) < 0 ? 0 : maxPathSum(root.left, max);
    int right = maxPathSum(root.right, max) < 0 ? 0 : maxPathSum(root.right, max);
    max[0] = Math.max(max[0], left + right + root.key);
    return left > right ? left + root.key : right + root.key;
  }
}
