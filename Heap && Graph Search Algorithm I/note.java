Heap : Priority Queue
Heap -> It is unsorted array but have SPECIAL RULES to follow.

Heap is implemented by binary heap a. MAX Heap
								   b. MIN Heap

Rules: a. Every children is smaller than its parent
	   b. It is a complete tree.
	   c. Lnode = parentNode * 2 + 1
	   d. Rnode = parentNode * 2 + 2

Primary Operation: 
	insert -> O(logn)
	update -> O(logn) Maintain the property of heap
	get/top -> O(1)
	pop -> O(logn)
	heapify -> O(n)

Example: K smallest in unsorted array.
		a). maxHeap(minHeap)
		b). quick selection


Graph:

Adjacent List can be implementd by hashMap.
Key : node.
Value : List of successors node.
<node> <List of successors node> 

class GraphNode {
	int value;
	String name;
	List<GraphNode> successors;
}

Common Graph search algorithm:

1. BFS1 (Breadth First Search)
 a. First, Expand a node. 
 b. Generate its neighboring node. 
 c. Maintain a FIFO Queue: put all generated nodes in the Queue.
 d. Termination condition: do a loop until the Queue is empty.


 BFS traverse the Graph way: traverse all the node.

 For one node:
 		Queue<GraphNode> qu = new LinkedList<>();
 		qu.offer(node);
 		while (!qu.isEmpty()) {
 			GraphNode curNode = qu.poll();
 			for (GraphNode nei : curNode.neighbors) {
 				qu.offer(nei);
 			}
 		}


2. BFS2 (Best First Search)
	Dijkstra Algorithm
		Usage: Find the shortest path from a single node to any other nodes in that graph (single source node)
		Data Structure: Priority Queue







