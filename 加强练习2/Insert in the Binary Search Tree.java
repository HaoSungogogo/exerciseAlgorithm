
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

Interative way:

public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    TreeNode parent = null;
    TreeNode cur = root;
    while (cur != null) {
      if (cur.key == key) {
        return root;
      }
      if (cur.key > key) {
        parent = cur;
        cur = cur.left;
      } else {
        parent = cur;
        cur = cur.right;
      }
    }
    if (parent.key > key) {
      parent.left = new TreeNode(key);
    } else {
      parent.right = new TreeNode(key);
    }
    return root;
  }
}

Recursive way:


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
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    if (root.key > key) {
      root.left = insert(root.left, key);
    } else if (root.key < key) {
      root.right = insert(root.right, key);
    }
    return root;
  }
}
