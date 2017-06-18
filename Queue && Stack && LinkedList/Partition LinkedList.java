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
  public ListNode partition(ListNode head, int target) {
   if (head == null || head.next == null) {
     return head;
   }
   ListNode small = new ListNode(-1);
   ListNode curSmall = small;
   ListNode large = new ListNode(-1);
   ListNode curLarge = large;
   while (head != null) {
     if (head.value < target) {
       curSmall.next = head;
       curSmall = curSmall.next;
     } else {
       curLarge.next = head;
       curLarge = curLarge.next;
     }
     head = head.next;
   }
   curSmall.next = large.next;
   curLarge.next = null;          to avoid cycle !!!
   return small.next;
  }
}
