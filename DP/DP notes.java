The key for DP problem:
1. find the meaning of each element in the table
2. fill in the table

The relation with Recursion:

1. Recursion solve the problem from the large size to small size, and do not record any sub-problem, only think about:
	a. base case
	b. recursion rule
2. DP solve the proble from small size to large size and record sub-problem
	a. base case
	b. induction rule 
       (size(< n) subsolution-> size(n) solution)

ONE DIMENSION DP:

if the weight of each smallest elemnet in the original data is identical/similar:
	eg: identical -> 1 meter rope
		similar -> a letter, a number
	This kind of problem is usually simple:
		Linear scan and look back to the previous element!!

	eg: Largest Ascending Subarray
		Largest Ascending Subsequence
		Cut Rope
		Cut Palindrome

if the weight is not same:
	we usually need to try out all possible k that(i < k < j), M[i][j] = max(M[i][k], M[k][j])