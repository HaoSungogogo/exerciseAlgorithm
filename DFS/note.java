Recursion   Vs    DFS
DFS, in more general scope, it is one of search algorithm.
DFS can be implemented in either recursion way or iterative way.

Key point to solve the problem:
	a. what does it store on each level? 
	   (what every level represents and how many level does the recursion tree have)
	b. how many states should we try to put on this level.


Problem categories:
	a. Subset Problem -> n- branches method: for (int i = index; i < length; i++) -> dfs(level = i + 1)
	b. Permutation Problem -> Using In Place Swap. for (int i = index; i < length; i++) -> swap(array, index, i)
	c. Condition DFS
	d. 99 cent
