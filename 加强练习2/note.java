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

