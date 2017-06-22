Using sliding window.
Using HashMap to record the model
Since the matches is the fixed length pattern, the length of sliding window is fixed. 
So when we push it, we need to pop it.



public class Solution {
  List<Integer> allAnagrams(String s, String l) {
    List<Integer> list = new ArrayList<>();
    if (l.length() <= 0) {
      return list;
    }
    Map<Character, Integer> map = getMap(s);
    int matches = map.size();
    char[] arr = l.toCharArray();
    int fast = 0;
    while (fast < arr.length) {
      Integer cur = map.get(arr[fast]);
      if (cur != null) {
        map.put(arr[fast], cur - 1);
        if (cur == 1) {
          matches--;
        }
      }
      if (fast >= s.length()) {
        Integer slowNum = map.get(arr[fast - s.length()]);
        if (slowNum != null) {
          map.put(arr[fast - s.length()], slowNum + 1);
          if (slowNum == 0) {
            matches++;
          }
        }
      }
      if (matches == 0) {
        list.add(fast - s.length() + 1);
      }
      fast++;
    }
    return list;
  }
  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] arr = s.toCharArray();
    for (char iter : arr) {
      Integer cur = map.get(iter);
      if (cur != null) {
        map.put(iter, cur + 1);
      } else {
        map.put(iter, 1);
      }
    }
    return map;
  }
}
