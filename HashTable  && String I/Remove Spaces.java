Delete all duplicated spaces and tailing spaces
In the lase, we delete the leading spaces
!!!!!And pay attention to the slow > 0 condition, to prevent slow to be -1


public class Solution {
  public String removeSpaces(String input) {
    if(input.length() == 0) return input;
    char[] arr = input.toCharArray();
    int slow = 0;
    for(int fast = 0; fast < arr.length; fast++) {
      if(arr[fast] == ' ' && (fast + 1 == arr.length || arr[fast + 1] == ' ')) {
        continue;
      }else {
        arr[slow++] = arr[fast];
      }
    }
    if(arr[0] == ' ' && slow > 0) {
      return new String(arr, 1, slow - 1);
    }
    return new String(arr, 0, slow);
  }
  private void swap(int i, int j, char[] arr) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}



public class Solution {
  public String removeSpaces(String input) {
    char[] arr = input.toCharArray();
    int i = 0;
    int j = 0;
    while (j < arr.length) {
      if (arr[j] == ' ' && (j == 0 || arr[j - 1] == ' ')) {    // two situation j == 0 or normal
        j++;
      } else {
        arr[i++] = arr[j++];
      }
    }
    if (i - 1 >= 0 && arr[i - 1] == ' ') {      // avoid NPE
      return new String(arr, 0, i - 1);
    } else {
      return new String(arr, 0, i);
    }
  }
}


