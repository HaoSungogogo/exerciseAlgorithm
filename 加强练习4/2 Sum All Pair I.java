public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> values = map.get(target - array[i]);
      if (values != null) {
        for (int v : values) {
          List<Integer> list = new ArrayList<>();
          list.add(v);
          list.add(i);
          res.add(list);
        }
      }
      if (!map.containsKey(array[i])) {
        map.put(array[i], new ArrayList<>());
      }
      map.get(array[i]).add(i);
    }
    return res;
  }
}
