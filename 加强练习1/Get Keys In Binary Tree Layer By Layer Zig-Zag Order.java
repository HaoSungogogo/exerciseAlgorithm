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
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Deque<TreeNode> deque = new LinkedList<>();
    int flag = -1;
    deque.offerFirst(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        if (flag > 0) {
          TreeNode temp = deque.pollFirst();
          list.add(temp.key);
          if (temp.left != null) {
            deque.offerLast(temp.left);
          }
          if (temp.right != null) {
            deque.offerLast(temp.right);
          }
        } else {
          TreeNode temp = deque.pollLast();
          list.add(temp.key);
          if (temp.right != null) {
            deque.offerFirst(temp.right);
          }
          if (temp.left != null) {
            deque.offerFirst(temp.left);
          }
        }
      }
      flag = -flag;
    }
    return list;
  }
}

Using deque.