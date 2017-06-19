public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array.length == 0 || k == 0) {
      return new int[0];
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        if (o1.equals(o2)) {
          return 0;
        }
        return o1 > o2 ? -1 : 1;
      }
    });
    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }
    int[] res = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      res[i] = maxHeap.poll();
    }
    return res;
  }
}


a. Maxheap needs Comparator
b. Using equals not == !!!




QUICK-SELECT way:

public class Solution {
  public int[] kSmallest(int[] array, int k) {
    if (array.length == 0 || k == 0) {
      return new int[0];
    }
    quickSelect(array, 0, array.length - 1, k);
    int[] res = Arrays.copyOf(array, k);
    Arrays.sort(res);
    return res;
  }
  private void quickSelect(int[] array, int min, int max, int target) {
    int index = partition(array, min, max);
    if (index == target - 1) {
      return;
    } else if (index > target - 1) {
      quickSelect(array, min, index - 1, target);
    } else {
      quickSelect(array, index + 1, max, target);
    }
  }
  private int partition(int[] array, int min, int max) {
    int pivot = array[max];
    int start = min;
    int end = max - 1;
    while (start <= end) {
      if (array[start] < pivot) {
        start++;
      } else if (array[end] > pivot) {
        end--;
      } else {
        swap(array, start++, end--);
      }
    }
    swap(array, start, max);
    return start;
  }
   private void swap(int[] array, int min, int max) {
      int temp = array[min];
      array[min] = array[max];
      array[max] = temp;
    }
}

Time complexity: worst case: O(n^2)
                 average case: O(n)
