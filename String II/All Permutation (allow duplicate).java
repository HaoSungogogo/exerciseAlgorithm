// due to allow duplicate, we could use set to find whether it is duplicate or not.
Using Set to rule out the duplicate element.

public class Solution {
  public List<String> permutations(String set) {
    List<String> list = new ArrayList<String>();
    if(set == null) {
      return list;
    }
    char[] arr = set.toCharArray();
    dfs(arr, 0, list);
    return list;
  }
  private void dfs(char[] arr, int level, List<String> list) {
    if(level >= arr.length) {
      list.add(new String(arr));
    }
    Set<Character> set = new HashSet<>();
    for(int i = level; i < arr.length; i++) {
      if(set.add(arr[i])) {
        swap(arr, level, i);
        dfs(arr, level + 1, list);
        swap(arr, level, i);
      }
    }
  }
  private void swap(char[] arr, int left, int right) {
    char temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
