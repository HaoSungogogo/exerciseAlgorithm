public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      pq.offer(new Pair(array[i], i));
    }
    List<Integer> list = new ArrayList<>();
    list.add(pq.peek().val);
    for (int i = k; i < array.length; i++) {
      pq.offer(new Pair(array[i], i));
      while (pq.peek().index < i - k + 1) {
        pq.poll();
      }
      list.add(pq.peek().val);
    }
    return list;
  }
  class Pair implements Comparable<Pair> {
    int val;
    int index;
    public Pair (int val, int index) {
      this.val = val;
      this.index = index;
    }
    //Override
    public int compareTo(Pair another) {
      if (this.val == another.val) {
        return 0;
      }
      return this.val < another.val ? 1 : -1;
    }
  }
}

Lazy deletion.
Time: O((n-k)logk)

public class Solution {
  public List<Integer> maxWindows(int[] array, int k) {
    Deque<Integer> deque = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
        deque.pollFirst();
      }
      if (i >= k - 1) {
        list.add(array[deque.peekFirst()]);
      }
    }
    return list;
  }
}

Using 单调栈
O(n)