DP summary:
1. 1D dp (1D oringinal data , such as rope, wood / MAX, MIN / cut or merge)
 1) if the weight of each smallest element in the oringinal data is identical / similar
	linear scan and look back to the previous element.
	eg:
	Longest Ascending Subarray (when at i, look back to i - 1)
	Longest Ascending Subsequence (when at i, look back to 0 ~ i - 1)
	Cut Rope
	Cut Palindrome
 2) the weight is not the same.
	沙子归并
	切木头
	中心开花 for each M[i, j], usually try out all possible k, M[i, j] = max (M[i, k] +/-/ * / M[k, j])

 3) Pizza problem. 两头凑

2D DP
1) Matrix problem
2) Two String (Edit Distance, Longset Common Substring, Longset Common Subsequence).
	Key of thinking, the i-th element in S1 compare with the j-th element in S2 -> induction rule is involved with 
	M[i][j] and M[i - 1][j - 1] / M[i - 1][j] / M[i][j - 1]




log
1) binary 
2) merge sort
3) heap 
4) bianry search