1. Binary Search Problem
	run binary search among the two arrays, not only on the one array.
	1) given two sorted arrays, how to find median of two arrays?
	2) given two sorted arrays, how to find the k-th smallest element from them?

	Solution 1: 谁小移谁
	Solution 2: binary search
	key of thinking:
	a) 把A[N] and B[M] 的各自前 k／2 比较，每次删除 k／2
	b) compare A[k/2 - 1] and B[k/2 - 1], 谁小移谁 

2. Sliding window problem
	(1) fixed length
	(2) unfixed length
	Data Structure
	(1) HashMap
	(2) Stack