/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    int onelen = getLength(one);
    int twolen = getLength(two);
    if (onelen < twolen) {
      return merge(one, two, twolen - onelen);
    } else {
      return merge(two, one, onelen - twolen);
    }
  }
  private int getLength(TreeNodeP one) {
    int res = 0;
    while(one != null) {
      res++;
      one = one.parent;
    }
    return res;
  }
  private TreeNodeP merge(TreeNodeP shorter, TreeNodeP longer, int dif) {
    while(dif > 0) {
      longer = longer.parent;
      dif--;
    }
    while (shorter != longer) {
      shorter = shorter.parent;
      longer = longer.parent;
    }
    return longer;
  }
}


Due to having parent pointer, we do not need root treenode.
Before merge two list, get the length of each list then move to the same start point.