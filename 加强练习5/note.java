1. Common Elements Problem
	1）Common Elements in two array
		Assumption: sorted?
		a) sorted, Two pointer m ~ n, O(m + n), 谁小移谁。
		b) unsorted, m << n, HashSet, space O(m), time O(m + n)
		c) sorted, m << n, binary search O(mlogn)
	2) Common Elements in three array.
		a) Three pointer m ~ n, O(n), 谁小移谁。
		b) Iterative way, O(n)
	3) Common Elements in k arrays.
		a) minHeap does not work.
		b) binary reduction. Time: O(kn) = kn + 1/2 kn + 1/4 kn + ...
		c) iterative way. Time: O(kn)

!!!最～～问题：
1) BFS2
2) DP
3) BFS1 (如果边权重为1)
4）DFS (permunate all the possible solution)

!!!第几小 -> generally, it is BFS2 problem.

BFS2 steps:
	1) Initial state.
	2) Expansion rule / Generation rule.
	3) Termination condition.
	4) Be care for deduplication.

1) Largest Product of Length
	Initial state: <s1, s2>
	Expansion rule / Generation rule: expand <si, sj>
									  generate <si + 1, sj>
									  generate <si, sj + 1>
	Termination condition: 
		a) the first pair that is poped out does not have common elements.
		b) pq is empty -> no solution.

2) Kth Smallest With Only 3, 5, 7 As Factors
	Initial State: <1, 1, 1>
	Expansion rule / Generation rule: expand <i, j, k>
									  generate <i + 1, j, k>
									  generate <i, j + 1, k>
									  generate <i, j, k + 1>

	Termination condition: kth is popped out.
	Deduplication: Using Set.

3) Place To Put The Chair I
	Solution1: for every location, run the dijkstra, and update the global min.
		Time: O(n^2 * n^2logn^2) = O(n^4 * logn).
	Solution2: run dijkstra from k equipment.
		Time: O(k * n^2 * logn)	

Problem Solving:
1GB memory, two 100GB hard disk, sort 80GB integers of 64 bits.

Assumption: 
	80GB integer is put on HD1
	Optimize the time?
	Ascending
	Maintain the original data

External Sort -> Using external memory to sort.
Step1:
400 chunks -> 0.2 GB each
Step2:
Read it from disk to memory. Sort it and write back to disk.
Step3:
Read from disk the first block of all the chunks into memory array (in memory buffer).
Array1: XXXXXXXXX
Array2: XXXXXXXXX
.
.
.
Array400: XXXXXXXXX

one result buffer: YYYYYYYYYY

For the 400 arrays, do the 谁小移谁。
Whenever we finish a block, write it to the dist and at the same time, read next block, repeat.

For each element, we only read and write only once.

Binary reduction is read and write log400 times.


2. Histogram problem.
	1) Largest Rectangle In Histogram
		a) 中心开花。 O(n^2)
		b) 单调栈： maintain a stack to store the indices of column forming the acending order.
				   left border is current index, right border is the index of top element in the stack + 1
	2) 直方图蓄水
		a) 中心开花。 O(n^2)
		b) DP
		c) Optimized way.
			Two pointer (i, j) and maintian a leftmax and rightmax
			case1: leftmax < rightmax
					calculate the water at i
					i++
			case2: letmax > rightmax 
					calculate the water at j
					j--
			"this is because we only care about the min of leftmax and rightmax"
	3) 三维蓄水
		similar to above queston.
		left and right -> the border
		minheap to get the smallest one in the border -> exapand and generate the neighbor










