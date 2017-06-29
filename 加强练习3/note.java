Recursion III
Type 1:
Using recursion to return values in a bottom-up way in binary tree.

Path Problem in Binary Tree.

1. 人字形 -> need values from 'bottom-up -> similar as post-order'
Maximum Path Sum Binary Tree I (leaf node to leaf node):
Way of thinking:
1). What do you expect from your lchild and rchild?
	Max single path from left subtree.
	Max single path from right subtree.
2). What do you want to do in the current layer?
	update global_max if feasible.
3). What do you want to report to your parent? (Q1 == Q3)

Maximum Path Sum Binary Tree II (any node to any node):

Way of thinking:
1). What do you expect from your lchild and rchild?
	Max single path from left subtree, if it is negative, discard it.
	Max single path from right subtree, if it is negative, discard it.
2). What do you want to do in the current layer?
	update global_max if feasible.
3). What do you want to report to your parent? (Q1 == Q3)

2. root top down path (直上直下)  'similar to dfs, similar to pre-order'
Key point : keep a 'prefix path' from root while traversing.
Passing down the prefix sum (value).