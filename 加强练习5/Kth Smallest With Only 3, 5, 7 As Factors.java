public class Solution {
  public long kth(int k) {
    PriorityQueue<Long> pq = new PriorityQueue<>();
    Set<Long> set = new HashSet<>();
    pq.offer(3 * 5 * 7L);
    set.add(3 * 5 * 7L);
    for (int i = 0; i < k - 1; i++) {
      long cur = pq.poll();
      if (!set.contains(cur * 3)) {
        pq.offer(cur * 3);
        set.add(cur * 3);
      }
      if (!set.contains(cur * 5)) {
        pq.offer(cur * 5);
        set.add(cur * 5);
      }
      if (!set.contains(cur * 7)) {
        pq.offer(cur * 7);
        set.add(cur * 7);
      }
    }
    return pq.peek();
  }
}
