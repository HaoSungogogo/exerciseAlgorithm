public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, new Comparator<List<Integer>> () {
      public int compare(List<Integer> o1, List<Integer> o2) {
        int dis1 = distance(o1, a, b, c);
        int dis2 = distance(o2, a, b, c);
        if (dis1 == dis2) {
          return 0;
        }
        return dis1 < dis2 ? -1 : 1;
      }
    });
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> cur = Arrays.asList(0, 0, 0);
    pq.offer(cur);
    set.add(cur);
    for (int i = 0; i < k - 1; i++) {
      List<Integer> list = pq.poll();
      List<Integer> n = Arrays.asList(list.get(0) + 1, list.get(1), list.get(2));
      if (n.get(0) < a.length && set.add(n)) {
        pq.offer(n);
      }
      n = Arrays.asList(list.get(0), list.get(1) + 1, list.get(2));
      if (n.get(1) < b.length && set.add(n)) {
        pq.offer(n);
      }
      n = Arrays.asList(list.get(0), list.get(1), list.get(2) + 1);
      if (n.get(2) < c.length && set.add(n)) {
        pq.offer(n);
      }
    }
    return Arrays.asList(a[pq.peek().get(0)], b[pq.peek().get(1)], c[pq.peek().get(02)]);
    
  }
  private int distance(List<Integer> list, int[] a, int[] b, int[] c) {
    return a[list.get(0)] * a[list.get(0)] + b[list.get(1)] * b[list.get(1)] + 
    c[list.get(2)] * c[list.get(2)];
  }
}
