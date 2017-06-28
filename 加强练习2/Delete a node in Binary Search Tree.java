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
  public TreeNode delete(TreeNode root, int key) {
    if (root == null) {
      return root;
    }
    if (root.key > key) {
      root.left = delete(root.left, key);
    } else if (root.key < key) {
      root.right = delete(root.right, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      } else {
        TreeNode smallest = findSmallest(root.right);
        root.key = smallest.key;
        root.right = delete(root.right, smallest.key);
      }
    }
    return root;
  }
  private TreeNode findSmallest(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
