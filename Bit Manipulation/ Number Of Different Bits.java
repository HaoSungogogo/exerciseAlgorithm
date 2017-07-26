public class Solution {
  public int diffBits(int a, int b) {
    int c = a ^ b;
    int count = 0;
    while (c != 0) {
      count += (c & 1);
      c >>>= 1;
    }
    return count;
  }
}
