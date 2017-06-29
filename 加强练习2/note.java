1. Skiplist / Graph Copy problem:

Shallow copy -> copy name card / copy reference
Deep copy -> copy reference and its object。

Key Point: 建立 original node 和 copy node 一一对应的关系， 防止 original node 被重复 copy 一次以上。 -> Using HashMap.
Thought: "traverse the old list or graph", in this process, we copy it.

Graph Deep Copy:
a) BFS1
b) DFS

Graph Search: Must "maintain a map" to decide whether the node has been traversed.

BFS1: do not care node has been in the map and also do not put them in the queue.

for (GraphNode node : graph) {
	if (!map.containsKey) {
		map.put();
		qu.offer(node);
		while() {
			GraphNode temp = qu.poll();
			for (GraphNode nei : temp.neighbors) {
				if (!map.containsKey) {
					map.put();
					qu.offer()
				}
			}
		}
	}
}

DFS: do not care node has been in the map and also do not put them in next level dfs.

for (GraphNode node : graph) {
	if (!map.containsKey()) {
		map.put();
		dfs(node);
	}
}
dfs(node) {
	for (GraphNode temp : node.neighbors) {
		if (!map.containsKey()) {
			dfs(temp);
		}
	}
}


2. K-Way merge:
1) 谁小移谁 -> O(nklogk)
 比读写次数： 读一次写一次。
2) Binary Reduction -> O(nk * logk)
 读logk次
3) Iterative way: O(2n + 3n + 4n + ... + kn) = O(k^2 * n)


3. Binary Search Tree
Using the bst property to traverse.
a) Closest Number In Binary Search Tree -> maintain a solution node.
b) Largest Number Smaller In Binary Search Tree
c) Delete in Binary Search Tree
  1) the node is leaf node, delete the node and return null.
  2) the node has only one not null child, delete the node and return its non-null child.
  3) if the node has both left and right child, 
		1. find the smallest node in the right subtree
		2. copy the value from 12.5 to 12
		3. recurse again to delete the step 1 node.







