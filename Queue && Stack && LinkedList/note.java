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




LinkedList
 
class ListNode {
	public int val;
	public ListNode next;
}

Key points: 1. When you want to de-reference a ListNode, make sure it is not a null pointer.(NPE)
			2. Never lost the control of the head of the LinkedList.

Common interview questions
1. Reverse LinkedList.
	a. iterative way
	b. recursive way

2. Find the middle node of LinkedList
	fast and slow pointer
	while (fast.next != null && fast.next.next != null)
	Stop in advance!!!

3. Check if it has a cycle.
	Using slow ans fast pointer.

4. Insert in sorted LinkedList
	Using only one cur pointer to traverse and STOP IN ADVANCE, which makes the location of insertion is cur.next.
	while (cur.next != null && cur.next.value <= value)

5. Merge two sorted LinkedList into one long sorted LinkedList
	Using dummy node.

6. Reorder LinkedList
	a. parition
	b. reverse
	c. merge

7. Partition the LinkedList


