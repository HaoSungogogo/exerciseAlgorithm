public class Solution {
  public double median(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    int size = a.length + b.length;
    if (size % 2 == 0) {
      int left = kth(a, b, size / 2);
      int right = kth(a, b, size / 2 + 1);
      return (double)(left + right) / 2;
    } else {
      return kth(a, b, size / 2 + 1);
    }
  }
  private int kth(int[] a, int[] b, int k) {
    return kth(a, 0, b, 0, k);
  }
  private int kth(int[] a, int ai, int[] b, int bi, int k) {
    if (ai >= a.length) {
      return b[bi + k - 1];
    }
    if (bi >= b.length) {
      return a[ai + k - 1];
    }
    if (k == 1) {
      return Math.min(a[ai], b[bi]);
    }
    int amid = ai + k / 2 - 1;
    int bmid = bi + k / 2 - 1;
    int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
    int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
    if (aval < bval) {
      return kth(a, amid + 1, b, bi, k - k / 2);
    } else {
      return kth(a, ai, b, bmid + 1, k - k / 2);
    }
  }
}
