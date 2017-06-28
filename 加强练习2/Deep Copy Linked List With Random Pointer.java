/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) {
      return head;
    }
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newHead = new RandomListNode(head.value);
    map.put(head, newHead);
    RandomListNode cur = newHead;
    while (head != null) {
      if (head.next != null) {
        RandomListNode temp = map.get(head.next);
        if (temp == null) {
          map.put(head.next, new RandomListNode(head.next.value));
        }
        cur.next = map.get(head.next);
      }
      if (head.random != null) {
         RandomListNode temp = map.get(head.random);
         if (temp == null) {
           map.put(head.random, new RandomListNode(head.random.value));
         }
         cur.random = map.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }
    return newHead;
  }
}
