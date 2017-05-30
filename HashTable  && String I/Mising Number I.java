1. The naive way: using HashSet

public class Solution {
  public int missing(int[] array) {
    if(array == null || array.length <= 0) {
      return 1;
    }
    int len = array.length;
    Set<Integer> set = new HashSet<>();
    for(int iter : array) {
      set.add(iter);
    }
    for(int i = 1; i <= len; i++) {
      if(!set.contains(i)) {
        return i;
      }
    }
    return len + 1;
  }
}

2. Using Sum

public class Solution {
  public int missing(int[] array) {
    if(array == null || array.length <= 0) {
      return 1;
    }
   int sum = 0;
   for(int iter : array) {
     sum += iter;
   }
   for(int i = 1; i <= array.length + 1; i++) {
     sum -= i;
   }
   return -sum;
  }
}

3. Using XOR
public class Solution {
  public int missing(int[] array) {
    if(array == null || array.length <= 0) {
      return 1;
    }
    int sum = 0;
    for(int iter : array) {
      sum = sum ^ iter;
    }
    for(int i = 1; i <= array.length + 1; i++) {
      sum = sum ^ i;
    }
    return sum;
  }
}

4. Swap to oringinal position
   the element of array.length + 1 must not have its own right place
   
public class Solution {
  public int missing(int[] array) {
    if(array == null || array.length <= 0) {
      return 1;
    }
    for(int i = 0; i < array.length; i++) {
      while(array[i] != i + 1 && array[i] != array.length + 1) {
        swap(i, array[i] - 1, array);
      }
    }
    for(int i = 0; i < array.length; i++) {
      if(array[i] != i + 1) {
        return i + 1;
      }
    }
    return array.length + 1;
  }
  private void swap(int i, int j, int[] array) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
