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
  public TreeNode reverse(TreeNode root) {
    TreeNode pre = null;
    TreeNode preRight = null;
    TreeNode cur = root;
    while (cur != null) {
      TreeNode next = cur.left;
      TreeNode right = cur.right;
      cur.left = pre;
      cur.right = preRight;
      pre = cur;
      cur = next;
      preRight = right;
    }
    return pre;
  }
}

Iterative way.

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
  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode newNode = reverse(root.left);
    root.left.right = root.right;
    root.left.left = root;
    root.right = null;
    root.left = null;
    return newNode;
  }
}

Recursion way.