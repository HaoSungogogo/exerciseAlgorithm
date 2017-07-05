public class Solution {
  public int largestProduct(String[] dict) {
    Arrays.sort(dict, new Comparator<String> () {
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
          return 0;
        }
        return s1.length() < s2.length() ? 1 : -1;
      }
    });
    PriorityQueue<Cell> pq = new PriorityQueue<>(11, new Comparator<Cell> () {
      public int compare(Cell e1, Cell e2) {
        if (e1.product == e2.product) {
          return 0;
        }
        return e1.product < e2.product ? 1 : -1;
      }
    });
    pq.offer(new Cell(0, 1, dict[0].length() * dict[1].length()));
    while (!pq.isEmpty()) {
      Cell cur = pq.poll();
      if (isDistinct(cur, dict)) {
        return cur.product;
      }
      if (cur.i + 1 < dict.length) {
        pq.offer(new Cell(cur.i + 1, cur.j, dict[cur.i + 1].length() * dict[cur.j].length()));
      }
      if (cur.j + 1 < dict.length) {
        pq.offer(new Cell(cur.i, cur.j + 1, dict[cur.i].length() * dict[cur.j + 1].length()));
      }
    }
    return 0;
  }
  private boolean isDistinct(Cell cur, String[] dict) {
    char[] one = dict[cur.i].toCharArray();
    char[] two = dict[cur.j].toCharArray();
    Set<Character> set = new HashSet<>();
    for (char temp : one) {
      set.add(temp);
    }
    for (char temp : two) {
      if (set.contains(temp)) {
        return false;
      }
    }
    return true;
  }
  
  class Cell {
    int i;
    int j;
    int product;
    public Cell (int i, int j, int product) {
      this.i = i;
      this.j = j;
      this.product = product;
    }
  }
}

Array.sort() -> redefine the Comparator<String>
