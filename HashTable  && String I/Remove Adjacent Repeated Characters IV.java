Assuming as a stack operation.
Pay attention to the slow would become -1, so it is corner case.



public class Solution {
  public String deDup(String input) {
    if(input == null || input.length() == 0) {
      return input;
    }
    char[] arr = input.toCharArray();
    int slow = 0;
    for(int fast = 1; fast < arr.length; fast++) {
      if(slow == -1 || arr[fast] != arr[slow]) {
        arr[++slow] = arr[fast];
      }else {
        while(fast < arr.length && arr[slow] == arr[fast]) {
          fast++;
        }
        fast--;
        slow--;
      }
    }
    return new String(arr, 0, slow + 1);
  }
}
