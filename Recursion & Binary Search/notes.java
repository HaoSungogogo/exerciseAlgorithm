Recursion 
表象上： function calls itself
实质上： boil down a big problem to smaller ones
Implementation: a) Base case: smallest problem to solve.
				b) Recursion rule: how to make the problem smaller (if we can resolve the same problem but with smaller size,
								   then what is left to do for the current problem size n)



Using recursion tree to analyze space and time complexity:

Total nodes in the recursion tree = O(2^n)
The time complexity on each node = O(1)
Total time complexity = O(2^n)

Space complexity = O(n)

Trick : for time complexity analysis, we only need to calculate the last level of nodes.


Binary Search:

1. Array has to be sorted.
2. Problem to solve -> a). find an element and number in the sorted array!!
					   b). closet element in sorted array!! (stop in advance and post processing)
					   c). last occurence in sorted array!! -> largest LessOrEqual than target. (最大的最小值)
					   d). first occurence in sorted array!! -> smallest LargeOrEqual than target. （最小的最大值）





Classical Binary Search: while(left <= right) 
(find an element)		 left = mid + 1;
						 right = mid - 1;

Variant Binary Search: while(left < right - 1)  (stop in advance and post processing)
(find closet, last	   left = mid;
 or first occurence)   right = mid; 
