String Removal Problem: 2 pointer

Using slow and fast pointer



public class Solution {
  public String remove(String input, String t) {
    if (input == null) {
      return null;
    }
    char[] arr = input.toCharArray();
    Set<Character> set = getSet(t);
    int slow = 0;
    for(int fast = 0; fast < arr.length; fast++) {
      if(!set.contains(arr[fast])) {
        swap(slow++, fast, arr);
      }
    }
    return new String(arr, 0, slow);
  }
  private Set<Character> getSet(String t) {
    Set<Character> set = new HashSet<>();
    for(int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
  private void swap(int i, int j, char[] arr) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
