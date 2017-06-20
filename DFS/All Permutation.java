public class Solution {
  public List<String> permutations(String set) {
    List<String> res = new ArrayList<String>();
    if(set == null){
      return res;
    }
    char[] arr = set.toCharArray();
    dfs(arr, 0, res);
    return res;
  }
  private void dfs(char[] arr, int level, List<String> res){
    if(level == arr.length){
      res.add(new String(arr));
      return;
    }
    for (int i = level; i < arr.length; i++) {
      swap(arr, level, i);
      dfs(arr, level + 1, res);
      swap(arr, level, i);
    }
  }
  private void swap(char[] arr, int i, int j){
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}


In place swap -> Permutation problem.