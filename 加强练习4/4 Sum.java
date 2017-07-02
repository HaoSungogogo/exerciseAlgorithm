public class Solution {
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    for (int j = 1; j < array.length; j++) {
      for (int i = 0; i < j; i++) {
        int sum = array[i] + array[j];
        if (map.containsKey(target - sum) && map.get(target - sum).right < i) {
          return true;
        }
        if (!map.containsKey(sum)) {
          map.put(sum, new Pair(i, j));
        }
      }
    }
    return false;
  }
  class Pair {
    int left;
    int right;
    public Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }
}

Using pairs to emulate 2 sum.
Must comply i < j < k < l.
j as small as possible, so for j to use loop.