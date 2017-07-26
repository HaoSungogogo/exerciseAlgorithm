public class Solution {
  public boolean isPowerOfTwo(int number) {
    return number > 0 && ((number - 1) & number) == 0;
  }
}
