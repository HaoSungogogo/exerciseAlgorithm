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
  public TreeNode reconstruct(int[] in, int[] level) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < in.length; i++) {
      map.put(in[i], i);
    }
    List<Integer> list = new ArrayList<>();
    for (int i : level) {
      list.add(i);
    }
    return reconstruct(list, map);
  }
  private TreeNode reconstruct(List<Integer> list, Map<Integer, Integer> map) {
    if (list.isEmpty()) {
      return null;
    }
    TreeNode root = new TreeNode(list.get(0));
    int index = map.get(list.get(0));
    List<Integer> llist = new ArrayList<>();
    List<Integer> rlist = new ArrayList<>();
    for (int i = 1; i < list.size(); i++) {
      if (map.get(list.get(i)) < index) {
        llist.add(list.get(i));
      } else {
        rlist.add(list.get(i));
      }
    }
    root.left = reconstruct(llist, map);
    root.right = reconstruct(rlist, map);
    return root;
  }
}

Time Complexity : O(n)