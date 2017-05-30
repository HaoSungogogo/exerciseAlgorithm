Using two pointer.
 
!! the result would include slow.

public class Solution {
  public String deDup(String input) {
    if(input.length() <= 0) return input;
    char[] arr = input.toCharArray();
    int slow = 0;
    for(int fast = 1; fast < arr.length; fast++) {
      if(arr[fast] != arr[slow]) {
        arr[++slow] = arr[fast];
      }
    }
    return new String(arr, 0, slow + 1);
  } 
}