class Solution {
	  public List<List<Integer>> kSubSet(int[] array, int k) {
		List<List<Integer>> list = new ArrayList<>();
	    if (array.length < k) {
	    	return list;
	    }
	    List<Integer> cur = new ArrayList<>();
	    dfs(list, array, k, cur, 0);
	    return list;
	  }
	  private void dfs(List<List<Integer>> list, int[] array, int k, 
			  List<Integer> cur, int level) {
		  if (cur.size() == k || level == array.length) {
			  if (cur.size() == k) {
				  list.add(new ArrayList<Integer>(cur));
			  }
			  return;
		  }
		  dfs(list, array, k, cur, level + 1);
		  cur.add(array[level]);
		  dfs(list, array, k, cur, level + 1);
		  cur.remove(cur.size() - 1);
	  }
	}

Pruning way -> get the size equals to k or get to the leaf.
Time complexity : O(2^n)
Space complexity : O(n)

class Solution {
	  public List<List<Integer>> subSet(int[] array, int k) {
		List<List<Integer>> list = new ArrayList<>();
	    if (array.length < k) {
	    	return list;
	    }
	    List<Integer> cur = new ArrayList<>();
	    dfs(list, cur, array, k, 0, 0);
	    return list;
	  }
	  private void dfs(List<List<Integer>> list, List<Integer> cur, int[] array, int k,
			  int index, int level) {
		  if (level == k) {
			  list.add(new ArrayList<Integer>(cur));
			  return;
		  }
		  for (int i = index; i < array.length; i++) {
			  cur.add(array[i]);
			  dfs(list, cur, array, k, i + 1, level + 1);
			  cur.remove(cur.size() - 1);
		  }
	  }
	}

K-nary Tree way.
Key Point: Never look back to previous elements, to avoid duplicate set in the solution.
Time complexity : O(2^n)
Space complexity : O(n) ????




