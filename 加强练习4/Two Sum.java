public class Solution {
  public boolean existSum(int[] array, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if(map.containsKey(target - array[i])) {
        return true;
      }
      map.put(array[i], i);
    }
    return false;
  }
}

Optimize time 
time complexity: O(n)
space complexity: O(n)

public class Solution {
  public boolean existSum(int[] array, int target) {
    Arrays.sort(array);
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      if (array[i] + array[j] == target) {
        return true;
      } else if (array[i] + array[j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }
}

Optimize space
time complexity: O(nlogn)
space complexity: O(1)