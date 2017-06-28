/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode merge(List<ListNode> listOfLists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>(11, new NewComparator());
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    for (ListNode node : listOfLists) {
      if (node != null) {
        pq.offer(node);
      }
    }
    while (!pq.isEmpty()) {
      ListNode temp = pq.poll();
      cur.next = temp;
      cur = cur.next;
      if (temp.next != null) {
        pq.offer(temp.next);
      }
    }
    return dummy.next;
  }
  class NewComparator implements Comparator<ListNode> {
    public int compare(ListNode o1, ListNode o2) {
      if (o1.value == o2.value) {
        return 0;
      }
      return o1.value < o2.value ? -1 : 1;
    }
  }
}
