public class Solution {
  public int kth(int[] a, int[] b, int k) {
    return kth(a, 0, b, 0, k);
  }
  private int kth (int[] a, int leftA, int[] b, int leftB, int k) {
    if (leftA >= a.length) {
      return b[leftB + k - 1];
    }
    if (leftB >= b.length) {
      return a[leftA + k - 1];
    }
    if (k == 1) {
      return Math.min(a[leftA], b[leftB]);
    }
    int leftANew = leftA + k / 2 - 1;
    int leftBNew = leftB + k / 2 - 1;
    int aval = leftANew >= a.length ? Integer.MAX_VALUE : a[leftANew];
    int bval = leftBNew >= b.length ? Integer.MAX_VALUE : b[leftBNew];
    if (aval < bval) {
      return kth(a, leftANew + 1, b, leftB, k - k / 2);
    } else {
      return kth(a, leftA, b, leftBNew + 1, k - k / 2);
    }
  }
}
