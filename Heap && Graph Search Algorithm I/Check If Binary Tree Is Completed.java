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
  public boolean isCompleted(TreeNode root) {
   if (root == null) {
     return true;
   }
   Queue<TreeNode> qu = new LinkedList<>();
   qu.offer(root);
   boolean flag = false;
   while (!qu.isEmpty()) {
     TreeNode curNode = qu.poll();
     if (curNode.left == null) {
       flag = true;
     } else if (flag) {
       return false;
     } else {
       qu.offer(curNode.left);
     }
     
     if (curNode.right == null) {
       flag = true;
     } else if (flag) {
       return false;
     } else {
       qu.offer(curNode.right);
     }
   }
   return true;
  }
}
