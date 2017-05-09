public class Solution {
  public String reverseWords(String input) {
    if(input == null || input.length() <= 1) {
      return input;
    }
    char[] arr = input.toCharArray();
    reverse(arr, 0, arr.length - 1);
    int i = 0;
    int j = 0;
    while(j < arr.length) {
      // find the start
      if(arr[j] != ' ' && (j == 0 || arr[j - 1] == ' ')){
        i = j;
      }
      // find the end
      if(arr[j] != ' ' && (j == arr.length - 1 || arr[j + 1] == ' ')){
        reverse(arr, i, j);
      }
      j++;
    }
    return new String(arr);
  }
  private void reverse(char[] arr, int i, int j) {
    while(i < j){
      swap(arr, i++, j--);
    }
  }
  
  private void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

// grasp the method of finding the start and end of a word in the String.