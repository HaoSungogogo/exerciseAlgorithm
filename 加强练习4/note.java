1. The problem of Reversal 
	-> all of problems are same with linkedlist reverse, by using recursion.
	-> 方框 + what do next except subproblem.

2. DFS 
a) What does it store on each level?
b) How many different states should we try to put on the each level?

2.1 Subsets problem
2.1.1 classical subset problem
2.1.2 How to divide an array into two parts, with their sum equals to each other
      -> Select some certain parts from an array to get certain sum.
2.1.3 Print all possible combination of k elements in array. (no duplicate)
	  -> select k elements
	  		-> pruning 
	  		-> k-nary tree
2.1.4 Given a sorted string of chars with duplicate chars, return all possible subsequence. (SubSet problem with duplicate elements)
	  a b c
	  0 0 0 
	  1 1 1

	  a b c
	  0 0 0
	  1 1 1
	    2 
	    3
2.1.5 = 2.1.4 + 2.1.3

2.2 All Permuation
1. without duplicate
2. with duplicate, by using set.

2.3 99 cent problem
2.3.1 classical 99 cent.  加
2.3.2 factor combination  乘

2.4 Parenthesis Problem
2.4.1 classical problem
2.4.2 all Parenthesis Permuation
 constrain1: left > right
 constrain2: left matches right.
Using stack
Detail:
1. if left remainNumber > 0, add left.
2. using stack to figure out whether it mathces. if so, add.
levels = 2 * (m + n + l)
states = the number of types of parentheses

