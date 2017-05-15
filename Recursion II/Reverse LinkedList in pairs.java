
Recursion is combined with LinkedList.



class ListNode {
   public int value;
   public ListNode next;
   public ListNode(int value) {
     this.value = value;
     next = null;
   }
}
 
public class Solution {
  public ListNode reverseInPairs(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode newNode = reverseInPairs(head.next.next);
    ListNode cur = head.next;
    cur.next = head;
    head.next = newNode;
    return cur;
  }
}
