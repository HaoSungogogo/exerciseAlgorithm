public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> list = new ArrayList<>();
    int ai = 0;
    int bi = 0;
    int ci = 0;
    while (ai < a.length && bi < b.length && ci < c.length) {
      if (a[ai] == b[bi] && b[bi] == c[ci]) {
        list.add(a[ai]);
        ai++;
        bi++;
        ci++;
      } else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
        ai++;
      } else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
        bi++;
      } else {
        ci++;
      }
    }
    return list;
  }
}
