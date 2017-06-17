public class Solution {
  private Deque<Integer> stack;
  private Deque<Pair> minVal;
  public Solution() {
    stack = new LinkedList<Integer>();
    minVal = new LinkedList<Pair>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    int loca = minVal.peekFirst().loc;
    if (stack.size() == loca) {
      minVal.pollFirst();
    }
    return stack.pollFirst();
  }
  
  public void push(int element) {
    stack.offerFirst(element);
    if (minVal.peekFirst() == null || element < minVal.peekFirst().val) {
      minVal.offerFirst(new Pair(element, stack.size()));
    } 
  }
  
  public int top() {
    return stack.isEmpty() ? -1 : stack.peekFirst();
  }
  
  public int min() {
    return minVal.isEmpty() ? -1 : minVal.peekFirst().val;
  }
  
  class Pair{
    public int val;
    public int loc;
    public Pair (int val, int loc) {
      this.val = val;
      this.loc = loc;
    }
  }
}
