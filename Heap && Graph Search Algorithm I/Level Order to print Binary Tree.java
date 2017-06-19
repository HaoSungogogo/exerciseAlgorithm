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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> qu = new LinkedList<>();
    qu.offer(root);
    while (!qu.isEmpty()) {
      int size = qu.size();
      List<Integer> newList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = qu.poll();
        newList.add(node.key);
        if (node.left != null) {
          qu.offer(node.left);
        }
        if (node.right != null) {
          qu.offer(node.right);
        }
      }
      list.add(newList);
    }
    return list;
  }
}
