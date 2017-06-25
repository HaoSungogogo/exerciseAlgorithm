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
	we usually need to try out all possible k that(i < k < j), M[i][j] = max(M[i][k] / + / - / * / M[k][j])
->
	左大段，右大段。 rope cutting
	左大段，右小段。 rope cutting ／ Dictionary world problem （大段，using history result()



Two DIMENSION DP:
	Edit Distance(M[i][j] = min(M[i - 1][j - 1], 1 + M[i - 1][j], 1 + M[i - 1][j - 1], 1 + M[i][j - 1]))
	Largest Square of 1s in a binary matrix (M[i][j] = min(M[i - 1][j - 1], M[i - 1][j], M[i - 1][j - 1], M[i][j - 1]))

The three prototypes as helper function:

1: the largest Subarray sum
public class Solution {
  public int largestSum(int[] array) {
    int local = array[0];
    int max = local;
    for (int i = 1; i < array.length; i++) {
      if (local < 0) {
        local = array[i];
      } else {
        local += array[i];
      }
      max = Math.max(max, local);
    }
    return max;
  }
}


2: the longest consecutive 1s

public class Solution {
  public int longest(int[] array) {
   if (array == null || array.length == 0) {
     return 0;
   }
   int local = array[0];
   int longest = local;
   for (int i = 1; i < array.length; i++) {
     if (array[i] == 0) {
       local = 0;
     } else {
       local += 1;
     }
     longest = Math.max(longest, local);
   }
   return longest;
  }
}

3: the Path-Prefix Sum problem.



