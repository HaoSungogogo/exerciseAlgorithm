Using two pointer to traverse every situation.
Pay attention to the times of iteration large.length() - small.length()

public class Solution {
  public int strstr(String large, String small) {
   if(large == null || small == null) {
     return -1;
   }
   int j;
   for(int i = 0; i <= large.length() - small.length(); i++) {
     for(j = 0; j < small.length(); j++) {
       if(large.charAt(i + j) != small.charAt(j)) {
         break;
       }
     }
     if(j == small.length()) {
       return i;
     }
   }
   return -1;
  }
}
