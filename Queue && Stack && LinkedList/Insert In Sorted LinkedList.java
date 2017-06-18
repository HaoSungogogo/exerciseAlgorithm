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
  public ListNode insert(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    if (head == null || head.value > value ) {
      newNode.next = head;
      return newNode;
    } 
    ListNode cur = head;
    while (cur.next != null && cur.next.value <= value) {
      cur = cur.next;
    }
    ListNode next = cur.next;
    cur.next = newNode;
    newNode.next = next;
    return head;
  }
}
