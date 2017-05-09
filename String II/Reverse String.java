
Using iterative way.

public class Solution {
  public String reverse(String input) {
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] arr = input.toCharArray();
    int i = 0;
    int j = arr.length - 1;
    while(i < j) {
      swap(arr, i++, j--);
    }
    return new String(arr);
  }
  private void swap(char[] arr, int i, int j){
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
}

Using recursion way.

public class Solution {
  public String reverse(String input) {
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] arr = input.toCharArray();
    recurse(arr, 0, arr.length - 1);
    return new String(arr);
  }
  private void recurse(char[] arr, int i, int j) {
    if(i >= j){
      return;
    }
    swap(arr, i++, j--);
    recurse(arr, i, j);
  }
  private void swap(char[] arr, int i, int j) {
     char temp = arr[i];
     arr[i] = arr[j];
     arr[j] = temp;
  }
}
