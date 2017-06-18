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
  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = findMiddle(head);
    ListNode two = slow.next;
    slow.next = null;
    two = reverse(two);
    return merge(head, two);
  }
  private ListNode findMiddle(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  private ListNode reverse(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode pre = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  private ListNode merge(ListNode one, ListNode two) {
    ListNode dummy = new ListNode(-1);
    ListNode cur = dummy;
    while (one != null && two != null) {
      cur.next = one;
      one = one.next;
      cur.next.next = two;
      two = two.next;
      cur = cur.next.next;
    }
    if (one != null) {
      cur.next = one;
    } 
    return dummy.next;
  }
}
