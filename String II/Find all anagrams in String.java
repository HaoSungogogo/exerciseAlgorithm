Using sliding window.
Using HashMap to record the model
Since the matches is the fixed length pattern, the length of sliding window is fixed. 
So when we push it, we need to pop it.



public class Solution {
  List<Integer> allAnagrams(String s, String l) {
    List<Integer> list = new ArrayList<>();
    if(l == null || s == null || s.length() > l.length()) {
      return list;
    }
    Map<Character, Integer> map = getMap(s);
    int match = 0;
    for(int i = 0; i < l.length(); i++) {
      Integer freq = map.get(l.charAt(i));
      if(freq != null) {
        map.put(l.charAt(i), freq - 1);
        if(freq == 1) {
          match++;
        }
      }
      
      if(i >= s.length()) {
        Integer freqslow = map.get(l.charAt(i - s.length()));
        if(freqslow != null) {
          map.put(l.charAt(i - s.length()), freqslow + 1);
          if(freqslow == 0) {
            match--;
          }
        }
      }
      if(match == map.size()) {
        list.add(i - s.length() + 1);
      }
    }
    return list;
  }
  
  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c : s.toCharArray()) {
      Integer freq = map.get(c);
      if(freq == null) {
        map.put(c, 1);
      }else {
        map.put(c, freq + 1);
      }
    }
    return map;
  }
}
