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
  public boolean exist(TreeNode root, int target) {
    if (root == null) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    return exist(root, set, 0, target);
  }
  private boolean exist(TreeNode root, Set<Integer> set, int prefixSum, int target) {
    if (root == null) {
      return false;
    }
    prefixSum += root.key;
    boolean flag = set.add(prefixSum);
    if (target == prefixSum || set.contains(prefixSum - target)) {
      return true;
    }
    boolean left = exist(root.left, set, prefixSum, target);
    boolean right = exist(root.right, set, prefixSum, target);
    if (flag) {
      set.remove(prefixSum);
    }
    return left || right;
  }
}

Time complexity : O(n)
Space complexity : O(n)