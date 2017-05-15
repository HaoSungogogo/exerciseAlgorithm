It is common problem of binary tree and recursion.
Reson: the property of every level is the same, it is easy to define recursion rule.

Base case: null pointer under the leaf

Way of Thinking:
1: What do you expect from your left child and right child.
2: What do you what to do in the current layer.
3. What do you want to report to your parent  (1 == 3)

Key Method: For maintain a global viarable in the process of recursion. We could put the viarable reference in the parameter of function.





LCA

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
// bast case:
    if(root == null) {
      return null;
    }
    if(root == one || root == two) {
      return root;
    }
// Step 1:
    TreeNode left = lowestCommonAncestor(root.left, one, two);        
    TreeNode right = lowestCommonAncestor(root.right, one, two);
// Step 2 + 3
    if(left != null && right != null) {
      return root;
    }
    return left != null ? left : right;
  }
}
