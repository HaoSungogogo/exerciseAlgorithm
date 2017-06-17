Logic data structure:

Queue: 
	usage: BFS related problem.
	Problem to solve: 1. Tree printout by level.
					  2. Sliding window problem -> or variant of Queue -> Deque

Stack:
Four popular interview questions:
	1. Implement Queue by two stacks
		stack1 : input
		stack2 : output

	2. Implement min() function by using two stacks with time complexity of O(1)
      	stack1 : input
      	stack2 : record the min value pair <value, size of stack1 when this value is added>

	3. Sort numbers with two stacks: similar to Selection Sort
		stack1 : input (3, 2, 1)
		stack2 : 1                                    (maintain a global min value)
				                                      (record size of stack2)

	4. Using multiple Stacks to implement a Deque

Problem to solve: need to linear scan an Array or String to get the newest element.