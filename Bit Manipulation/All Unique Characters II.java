public class Solution {
  public boolean allUnique(String word) {
    int[] map = new int[8];
    char[] array = word.toCharArray();
    for (char c : array) {
     if ((map[c / 32] >>> (c % 32) & 1) != 0) {
       return false;
     } else {
       map[c / 32] |= 1 << (c % 32);
     }
    }
    return true;
  }
}
