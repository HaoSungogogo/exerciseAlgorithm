package test;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.combinationK(new int[] {2, 1, 3, 4}, 2));
	}
}

 class Solution {
	  public List<List<Integer>> combinationK(int[] array, int k) {
		  List<List<Integer>> list = new ArrayList<>();
	    if (array == null || array.length <= k - 1) {
	    	return list;
	    }
	    List<Integer> cur = new ArrayList<>();
	    subSet(list, cur, array, k, 0);
	    return list;
	  }
	  private void subSet (List<List<Integer>> list, List<Integer> cur, int[] array,
			  int k, int level) {
		  if (cur.size() == k) {
			  list.add(new ArrayList<Integer>(cur));
			  return;
		  }
		  if (level == array.length) {
			  return;
		  }
		  subSet(list, cur, array, k, level + 1);
		  cur.add(array[level]);
		  subSet(list, cur, array, k, level + 1);
		  cur.remove(cur.size() - 1);
	  }
 }


k-nary tree
package test;
import java.util.*;

public class test {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.combinationK(new int[] {2, 1, 3, 4}, 2));
	}
}

 class Solution {
	  public List<List<Integer>> combinationK(int[] array, int k) {
		  List<List<Integer>> list = new ArrayList<>();
	    if (array == null || array.length <= k - 1) {
	    	return list;
	    }
	    List<Integer> cur = new ArrayList<>();
	    subSet(list, cur, array, k, 0);
	    return list;
	  }
	  private void subSet (List<List<Integer>> list, List<Integer> cur, int[] array,
			  int k, int index) {
		 if (cur.size() == k) {
			 list.add(new ArrayList<Integer>(cur));
			 return;
		 }
		 for (int i = index; i < array.length; i++) {
			 cur.add(array[i]);
			 subSet(list, cur, array, k, i + 1);
			 cur.remove(cur.size() - 1);
		 }
	  }
 }
