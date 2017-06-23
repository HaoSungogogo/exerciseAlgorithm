Recursion with String
Recursive way:


public class Solution {
  public boolean match(String input, String pattern) {
    return recurse(input, pattern, 0, 0);
  }
  private boolean recurse(String input, String pattern, int ipt, int ppt) {
    if(ipt == input.length() && ppt == pattern.length()) {
      return true;
    }
    if(ipt == input.length() || ppt == pattern.length()) {
      return false;
    }
    if(pattern.charAt(ppt) < '0' || pattern.charAt(ppt) > '9') {
      if(pattern.charAt(ppt) != input.charAt(ipt)) {
        return false;
      }else {
       return recurse(input, pattern, ipt + 1, ppt + 1); 
      }
    }
    int count = 0;
    while(ppt < pattern.length() && pattern.charAt(ppt) >= '0' && pattern.charAt(ppt) <= '9') {
      count = count *  10 + pattern.charAt(ppt) - '0';
      ppt++;
    }
    return recurse(input, pattern, ipt + count, ppt);
  }
}



Iterative way:

public class Solution {
  public boolean match(String input, String pattern) {
    int i = 0;
    int p = 0;
    while (i < input.length() && p < pattern.length()) {
      if (pattern.charAt(p) < '0' || pattern.charAt(p) > '9') {
        if (pattern.charAt(p) != input.charAt(i)) {
          return false;
        } else {
          i++;
          p++;
        }
      } else {
        int count = 0;
        while (p < pattern.length() && pattern.charAt(p) >= '0' && pattern.charAt(p) <= '9') {
          count = count * 10 + pattern.charAt(p) - '0';
          p++;
        }
        i += count;
      }
    }
    if (i == input.length() && p == pattern.length()) {
      return true;
    } else {
      return false;
    }
  }
}
