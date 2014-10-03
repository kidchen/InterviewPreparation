// LCA: lowest common ancestor

// if this is a bst:

// recursion:

public class LCA {
	

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode findLCA(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null || n1 == null || n2 == null) {
			return null;
		}
		if(root.val < Math.min(n1.val, n2.val)) {
			return findLCA(root.right, n1, n2);
		} else if(root.val > Math.max(n1.val, n2.val)) {
			return findLCA(root.left, n1, n2);
		} else {
			return root;
		}
	}

}
