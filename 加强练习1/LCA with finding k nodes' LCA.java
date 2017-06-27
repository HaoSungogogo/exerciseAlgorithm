public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = getSet(nodes);
    return recursion(root, set);
  }
  private Set<TreeNode> getSet(List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<>();
    for (int i = 0; i < nodes.size(); i++) {
      set.add(nodes.get(i));
    }
    return set;
  }
  private TreeNode recursion(TreeNode root, Set<TreeNode> set) {
    if (root == null || set.contains(root)) {
      return root;
    }
    TreeNode left = recursion(root.left, set);
    TreeNode right = recursion(root.right, set);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}


The same with classical LCA.