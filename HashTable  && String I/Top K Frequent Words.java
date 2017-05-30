# Using HashMap and PriorityQueue.
# Construct map using helper function.
# Convert PriorityQueue to String array to print out using helper function.

public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    if(combo == null || combo.length <= k) {
      return combo;
    }
    Map<String, Integer> map = getMap(combo);
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
    new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    });
    for(Map.Entry<String, Integer> entry : map.entrySet()) {
      if(minHeap.size() < k) {
        minHeap.offer(entry);
      }else {
        if(minHeap.peek().getValue() < entry.getValue()) {
          minHeap.poll();
          minHeap.offer(entry);
        }
      }
    }
    return toStringArray(minHeap);
  }
  private Map<String, Integer> getMap(String[] combo) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for(String iter : combo) {
      Integer count = map.get(iter);
      if(count != null) {
        map.put(iter, ++count);
      }else {
        map.put(iter, 1);
      }
    }
    return map;
  }
  private String[] toStringArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
    String[] res = new String[minHeap.size()];
    for(int i = res.length - 1; i >= 0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }
}
