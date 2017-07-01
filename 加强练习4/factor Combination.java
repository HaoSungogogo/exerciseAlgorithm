public class Solution {
	  public List<List<Integer>> factorCombination(int target) {
		List<List<Integer>> list = new ArrayList<>();
	    if (target <= 0) {
	    	return list;
	    } 
	    List<Integer> factor = getFactor(target);
	    List<Integer> cur = new ArrayList<>();
	    dfs(list, cur, factor, 0, target);
	    return list;
	  }
	  private void dfs(List<List<Integer>> list, List<Integer> cur, List<Integer> factor, 
			  int level, int remain) {
		  if (remain == 1 && level == factor.size()) {
			  list.add(new ArrayList<Integer>(cur));
			  System.out.println("debug1");
			  return;
		  }
		  if (level == factor.size()) {
			  System.out.println("debug2");
			  return;
		  }
		  cur.add(0);
		  dfs(list, cur, factor, level + 1, remain);
		  cur.remove(cur.size() - 1);
		  int count = 0;
		  while (remain % factor.get(level) == 0) {
			  count++;
			  remain = remain / factor.get(level);
			  cur.add(count);
			  dfs(list, cur, factor, level + 1, remain);
			  cur.remove(cur.size() - 1);
		  }
	  }
	  public List<Integer> getFactor(int target) {
		  List<Integer> list = new ArrayList<>();
		  for (int i = target - 1; i >= 2; i--) {
			  if (target % i == 0) {
				  list.add(i);
			  }
		  }
		  return list;
	  }
	}