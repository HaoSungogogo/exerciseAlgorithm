1. Since the two lists have benn sorted, so we use two pointer to iterate every element in two lists.
   Method: two pointer.

public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> list = new ArrayList<>();
    if(A == null || B == null) {
      return list;
    }
    int lenA = A.size();
    int lenB = B.size();
    int ptA = 0;
    int ptB = 0;
    while(ptA < lenA && ptB < lenB) {
      if(A.get(ptA) > B.get(ptB)) {
        ptB++;
      }else {
        if(A.get(ptA) < B.get(ptB)) {
          ptA++;
        }else {
          list.add(A.get(ptA));
          ptA++;
          ptB++;
        }
      }
    }
    return list;
  }
}

2. Using HashMap
   Convert Map to Set view in order to use iterator.

public class Solution {
  public List<Integer> common(List<Integer> A, List<Integer> B) {
    List<Integer> list = new ArrayList<>();
    if(A == null || B == null) {
      return list;
    }
    Map<Integer, Integer> mapA = new HashMap<>();
    Map<Integer, Integer> mapB = new HashMap<>();
    for(Integer iter : A) {
      Integer count = mapA.get(iter);
      if(count == null) {
        mapA.put(iter, 1);
      }else {
        mapA.put(iter, count + 1);
      }
    }
    for(Integer iter : B) {
      Integer count = mapB.get(iter);
      if(count == null) {
        mapB.put(iter, 1);
      }else {
        mapB.put(iter, count + 1);
      }
    }
    for(Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
      Integer count = mapB.get(entry.getKey());
      if(count != null) {
        count = Math.min(count, entry.getValue());
        while(count > 0) {
          list.add(entry.getKey());
          count--;
        }
      }
    }
    return list;
  }
}
