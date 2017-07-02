public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(array);
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      if (i > 0 && array[i] == array[i - 1]) {
        i++;
        continue;
      }
      int cur = array[i] + array[j];
      if (cur == target) {
        list.add(Arrays.asList(array[i], array[j]));
        i++;
        j--;
      } else if (cur > target) {
        j--;
      } else {
        i++;
      }
    }
    return list;
  }
}
