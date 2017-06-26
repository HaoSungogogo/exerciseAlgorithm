public class Solution {
  public int[] largestAndSmallest(int[] array) {
    List<Integer> large = new ArrayList<>();
    List<Integer> small = new ArrayList<>();
    int i = 0;
    while (i < array.length) {
      if (i + 1 >= array.length) {
        large.add(array[i]);
        small.add(array[i]);
        i++;
      } else {
        if (array[i] > array[i + 1]) {
          large.add(array[i++]);
          small.add(array[i++]);
        } else {
          small.add(array[i++]);
          large.add(array[i++]);
        }
      }
    }
    return new int[]{getLarge(large), getSmall(small)};
  }
  private int getLarge(List<Integer> large) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < large.size(); i++) {
      max = Math.max(max, large.get(i));
    }
    return max;
  }
  private int getSmall(List<Integer> small) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < small.size(); i++) {
      min = Math.min(min, small.get(i));
    }
    return min;
  }
}

The thought is the same as Binary Reduction.
Computation Complexity: n + n / 2  = 3 * n / 2.