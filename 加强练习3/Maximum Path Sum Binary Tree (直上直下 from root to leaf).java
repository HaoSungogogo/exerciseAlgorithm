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
Passing down the prefix sum.

public class Solution {
  public int getMaxPath(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    getMaxPath(root, 0, max);
    return max[0];
  }
  private void getMaxPath(TreeNode root, int prefixSum, int[] max) {
    if (root == null) {
      return; 
    }
    if (root.left == null && root.right == null) {
      max[0] = Math.max(max[0], prefixSum + root.key);
      return;
    }
    getMaxPath(root.left, prefixSum + root.key, max);
    getMaxPath(root.right, prefixSum + root.key, max);
  }
}

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
Getting the value from bottom-up.

public class Solution {
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    if (root.left == null && root.right == null) {
      return root.key;
    }
    int left = maxPathSum(root.left);
    int right = maxPathSum(root.right);
    if (root.left == null) {
      return right + root.key;
    } else if (root.right == null) {
      return left + root.key;
    } else {
      return Math.max(left, right) + root.key;
    }
  }
}
