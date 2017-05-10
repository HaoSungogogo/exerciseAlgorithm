
// We could consider the shorter String replace longer one or longer String replace shorter one
// For the first case, only need fast and slow pointer to traverse.
// For the second case, we need to create a resized array and use fast and slow pointer from end to start.




public class Solution {
  public String replace(String input, String s, String t) {
    char[] arr = input.toCharArray();
    if(s.length() > t.length()) {
      return replaceByShorter(arr, s, t);
    }else {
      return replaceByLonger(arr, s, t);
    }
  }
  
  private boolean equalSubString(char[] arr, int fast, String s) {
    int offset = 0;
    while(offset < s.length()) {
      if(arr[fast + offset] != s.charAt(offset)) {
        return false;
      }
      offset++;
    }
    return true;
  }
  
  private void copySubString(char[] arr, int slow, String t) {
    int offset = 0;
    while(offset < t.length()) {
      arr[slow + offset] = t.charAt(offset);
      offset++;
    }
  }
  
  private String replaceByShorter(char[] arr, String s, String t) {
    int slow = 0;
    int fast = 0;
    while(fast < arr.length) {
      if(fast <= arr.length - s.length() && equalSubString(arr, fast, s)) {
        copySubString(arr, slow, t);
        slow += t.length();
        fast += s.length();
      }else {
        arr[slow++] = arr[fast++];
      }
    }
    return new String(arr, 0, slow);
  }
  
  private String replaceByLonger(char[] arr, String s, String t) {
    ArrayList<Integer> list = getMatches(arr, s);
    char[] res = new char[arr.length + list.size() * (t.length() - s.length())];
    int fast = res.length - 1;
    int slow = arr.length - 1;
    int indexnumber = list.size() -1;
    while(fast >= 0) {
      if(indexnumber >= 0 && slow == list.get(indexnumber)) {
        copySubString(res, fast - t.length() + 1, t);
        fast -= t.length();
        slow -= s.length();
        indexnumber--;
      }else {
        res[fast--] = arr[slow--];
      }
    }
    return new String(res);
  }
  
  private ArrayList<Integer> getMatches(char[] arr, String s) {
    int i = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    while(i <= arr.length - s.length()) {
      if(equalSubString(arr, i, s)) {
        list.add(i + s.length() - 1);
        i += s.length();
      }else {
        i++;
      }
    }
    return list;
  }
  
  
  
  
  
  
  
  
}
