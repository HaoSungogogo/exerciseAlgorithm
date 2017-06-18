class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
}

Industrial usage:
	a. social network analysis
	b. information indexing
	c. information compression

Tree traverse:
	Implementation with recursion.

	1. pre-order:
		void preOrder (TreeNode root) {
			if (root == null) {
				return;
			}
			System.out.println(root.value);
			preOrder(root.left);
			perOrder(root.right);
		}

	2. in-order:
		void inOrder (TreeNode root) {
			if (root == null) {
				return null;
			}
			inOrder(root.left);
			System.out.println(root.value);
			inOrder(root.right);
		}

	3. post-order:
		void postOrder (TreeNode root) {
			if (root == null) {
				return null;
			}
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}

Trick: Base case always refers to null childNode below the leaf node!!!



The COMMON HELPER FUNCTION:
How to get the height of binary tree??

int getHeight(TreeNode root) {
	if (root == null) {
		return 0;
	}
	return 1 + Math.max(getHeight(root.left), getHeight(root.right));
}

The problem of Recurstion in Tree problem can be divided into two class:
1. put the value from top to end and then get value from end to top:
	eg: Check if the binary tree is BST.
2. only get value from end to top.
	eg: a) getHeight -> pass Integer value
		b) isBalanced -> pass boolean value
		c) isSymmetric -> pass boolean value








