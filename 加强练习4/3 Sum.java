public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    List<List<Integer>> list = new ArrayList<>();
    if (array == null) {
      return list;
    }
    Arrays.sort(array);
    for (int i = 0; i < array.length - 2; i++) {
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = array.length - 1;
      while (j < k) {
        if (j > i + 1 && array[j] == array[j - 1]) {
          j++;
          continue;
        }
        int cur = array[j] + array[k] + array[i];
        if (cur == target) {
          list.add(Arrays.asList(array[i], array[j], array[k]));
          j++;
          k--;
        } else if (cur > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return list;
  }
}

3 Sum is the same as 2 Sum, except setting the i pointer location first.