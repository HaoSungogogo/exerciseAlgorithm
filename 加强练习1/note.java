1. Element Deduplication and Removal in the array
a) leave only one duplicated elements
b) allow to leave two duplicated elements.
c) no duplicated elements
隔板题：
Two pointer: fast and slow with the same direction.
Property:
1) slow 隔板左边是处理好的元素，fast 右边是未处理的元素，之间的区域是无用区域，每次只要分析当前元素是否加入和移动slow 挡板。
2）同向而行，return 的结果中相对位置不变。

Two pointer: start and end with the different directions. -> Similar to Rainbow Sort
Property:
1) the left side to start is processed elements and the right side to end is processed elements, the middle part
   -> [left, right] is unkown area.
2) do not maintain the relative order.


!!!
How to solve k-something.
1) Binary Reduction     1   2   3   4   5   6   7   8
						  12      34      56      78
						  	  14              58
						  	  	      18
   For LCA problem with k node to find -> O(kn)

2) Iterative:
 1  2  -> 
 		  1  3 -> 
 		  		  1 4
 	Time complexity: O(kn)

 3) K-way all together.


LCA problem:
1) classical one. O(n) (without parent pointer)
2) clasiical one with parent pointer -> similar to merging the node of two single linkedlist. (since we have parent pointer, we could use our aimed TreeNode to traverse upside.)
 a) using hashmap, record one path
 b) getting two path length, move the lower node with the same level as higer node, move up together.
3) find k nodes LCA
4) find two nodes LCA in the k-nary tree
5) find k nodes LCA in the k-nary tree
6) find two nodes LCA in the binary search tree. O(height of Tree), it tree is balanced, O(logn) 
7) classical problem with large tree (MapReduce way)

Assuming we have 32 machines. In the level 5, we have 32 nodes.
case1: both node a and b are within top 5 levels
	Only call LCA(root, a, b, level_limit = 5)
case2: either a or b is within top 5 levels.
		Assuming is a, then we use MapReduce, Find(M1, b), ... , Find(M32, b)
		if M7 returns that it finds b, then LCA(root a, M7, level_limit = 5)
case3: a and b is not in the top 5 levels.
		we use MapReduce, Find(M1, b), ... , Find(M32, b)
		case3.1: a and b in different machines, say M3, M7, then call LCA(root, M3, M7, level_limit = 5)
		case3.2: a and b in the same machine
			case3.2.1: one machine returns a or b, then a or b is LCA
			case3.2.2: one machine returns c, then c is LCA




			