//Using I Love Yahoo Way

public class Solution {
  public String rightShift(String input, int n) {
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] arr = input.toCharArray();
    int index = n % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, index - 1);
    reverse(arr, index, arr.length - 1);
    return new String(arr);
  }
  
  private void reverse(char[] arr, int i, int j) {
    while(i < j){
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}
