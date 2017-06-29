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
    maxPathSum(root, 0, max);
    return max[0];
  }
  private void maxPathSum(TreeNode root, int prefixSum, int[] max) {
    if (root == null) {
      return;
    }
    if (prefixSum < 0) {
      prefixSum = root.key;
    } else {
      prefixSum += root.key;
    }
    max[0] = Math.max(max[0], prefixSum);
    maxPathSum(root.left, prefixSum, max);
    maxPathSum(root.right, prefixSum, max);
  }
}

Passing prefix sum down -> 一路到底



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
   int local = Math.max(0, Math.max(left, right)) + root.key;
   max[0] = Math.max(max[0], local);
   return local;
  }
}


Getting value from Bottom-Up.

