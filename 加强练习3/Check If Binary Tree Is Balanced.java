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
  public boolean isBalanced(TreeNode root) {
   if (root == null) {
     return true;
   }
   int left = getHeight(root.left);
   int right = getHeight(root.right);
   if (Math.abs(left - right) > 1) {
     return false;
   }
   return isBalanced(root.left) && isBalanced(root.right);
  }
  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return 1 + Math.max(left, right);
  }
}

Traditional method: Time Complexity : O(nlogn)
Similar to preorder traverse recursion way, do not need 三步曲.

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
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return recursion(root) == -1 ? false : true;
  }
  private int recursion(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = recursion(root.left);
    int right = recursion(root.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return 1 + Math.max(right, left);
  }
}

Getting the value from bottom-up, 三步曲。
Time Complexity : O(n)
Space Complexity : O(height)




