Using sliding window (slow and fast pointer)
slow: the begin index of solution
fast: current index
Using HashSet to record duplicate
How to move fast pointer: if no duplicate
How to move slow pointer and when to stop: if duplicate, slow++ and remove value in the Set.
                                           when remove the duplicate, stop.
How to update the final solution: when fast++, test and find max.

public class Solution {
  public int longest(String input) {
        int max = 0;
    if(input == null) {
      return max;
    }
    Set<Character> set = new HashSet<>();
    int fast = 0;
    int slow = 0;
    while(fast < input.length()) {
      if(set.contains(input.charAt(fast))) {
        set.remove(input.charAt(slow));
        slow++;
      }else {
        set.add(input.charAt(fast++));
        max = Math.max(max, fast - slow);
      }
    }
    return max;
  }
}
