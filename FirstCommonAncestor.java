/*
Given a binary tree, find the lowest common ancestor of two given nodes in the tree. 
*/

// O(n), O(logn) space for recursion

public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { 
	if (root == null) 
		return null;
	if (root == p || root == q) 
		return root;
	// Post order traveral
	TreeNode left = lowestCommonAncestor(root.left, p, q);
	TreeNode right = lowestCommonAncestor(root.right, p, q);
	if (left != null && right != null) { 
		return root;
	} else {
		return left != null ? left : right;
	} 
}


// follow up:
/***** what if this is a n-nary tree *****/
/*
if we have method to get parent node:
Assume the given two nodes are x and y.
1) find the depths of x and y, call the dx and dy, since we have parent function, this should be easy 
2) move deeper node up abs(dy-dx) steps first,
3) move both nodes up until the pointer are the same.
if not:
Pretty much the same as LCA of a BST, we just need to traverse all children.
Note: This code assumes that both the nodes (a and b) are present in the tree (check before do it) 
If only one of them is present then it will return that whereas it must return NULL for such a case. 
*/

Node LCA(Node a, Node b, Node root) {
	if(a == root || b == root) 
		return root;
	int count = 0; Node temp = null;
	for(Node iter : root.children) {
		Node res = LCA(a, b, iter); 
		if(res != null) {
			count++;
			temp = res; 
		}
	}
	if(count == 2) 
		return root;
	return temp;
}


/***** what if each node has a method to get its parent node *****/ 

// O(n), O(1) space

private int height (TreeNode root, TreeNode p) { 
	int height = 0;
	while(p != root) { 
		p = p.parent;
		height++; 
	}
	return height; 
}
public TreeNode LCA (TreeNode root, TreeNode p, TreeNode q) {
	// As root->parent is NULL, we don't need to pass root in.
	int h1 = height(p);
	int h2 = height(q);
	// swap both nodes in case p is deeper than q. 
	if(h1 > h2) {
		int temp = h1;
		h1 = h2;
		h2 = temp; 
		TreeNode node = p; 
		p = q;
		q = node; 
	}
	// invariant: h1 <= h2, q is deeper than p. int diff = h2 - h1;
	for (int h = 0; h < dh; h++) {
		q = q.parent; 
	}
	while (p != null && q != null) { 
		if (p == q) {
			return p; 
		}
		p = p.parent;
		q = q.parent; 
	}
	return Null; // p and q are not in the same tree 
}


/***** what if given more than two nodes *****/
// https://github.com/bio4j/examples/blob/develop/src/com/era7/bioinfo/bio4j/tools/algo/Taxono myAlgo.java
// http://bio4j.com/blog/2012/02/finding-the-lowest-common-ancestor-of-a-set-of-ncbi-taxonomy-no des-with-bio4j/
