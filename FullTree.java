// Recursion - DFS - stack
// Level Order Traversal - traversal all nodes
public boolean fullTree(TreeNode root) {
	if(root == null) {
		return true;
	}
	ArrayList<ArrayList<TreeNode>> allLevel = new ArrayList<ArrayList<TreeNode>>();
	helper(root, allLevel, 1);
	int level = allLevel.size() - 1;
	int lastLevel = allLevel.get(level).size();
	if(lastLevel = Math.pow(2, level)) {
		return true;
	}
	return false;
}

private void helper(TreeNode root, ArrayList<ArrayList<TreeNode>> allLevel, int level) {
	if(root == null) {
		return;
	}

	if(level > allLevel.size()) {
		allLevel.add(new ArrayList<TreeNode>());
	}
	allLevel.get(level - 1).add(root);
	helper(root.left, allLevel, level + 1);
	helper(root.right, allLevel, level + 1);
}


// try to use iteration rather than recursion (sometimes stack overflow when recursion going to deep)

// Method 1: by using "total nodes = 2 ^ level - 1" (level from 1)
// This will traverse the tree totally and calculate the rule
// Also, it use stack to do the preorder, O(n) time & O(logn) space

public boolean fullTree(TreeNode root) {
	ArrayList<TreeNode> eachLevel = new ArrayList<TreeNode>();
	if(root == null) {
		return true;
	}
	Stack<TreeNode> stack = new Stack<TreeNode>();
	int count = 0;
	int level = 0;
	// preorder to traversal the tree and count the total nodes number
	while(root != null || !stack.isEmpty()) {
		if(root != null) {
			stack.push(root);
			count++;
			root = root.left;
		} else {
			root = stack.pop();
			root = root.right;
		}
	}
	// left depth of the tree
	TreeNode depth = root;
	while(depth != null) {
		depth = depth.left;
		level++;
	}
	if(count == Math.pow(2, level) - 1) {
		return ture;
	}
	return false;
}

// Iteration - BFS - Queue

// Method 2: by level order traversal and check each level whether it is satisfied with "nodes = 2 ^ level" (level from 0)
// Use a queue to store the current level nodes and two counters to calculate current level nodes total and next level nodes total
// O(n), O(logn), but not need to traverse all nodes unless the worst case

public boolean fullTree(TreeNode root) {
	if(root == null) {
		return true;
	}
	Queue<TreeNode> queue = new Queue<TreeNode>();
	queue.push(root);
	int level = 0;
	int curLevel = 1;
	int nextLevel = 0;
	while(!queue.isEmpty()) {
		TreeNode cur = queue.pop();
		curLevel--;
		if(cur != null) {
			if(cur.left != null) {
				queue.push(cur.left);
				nextLevel++;
			}
			if(cur.right != null) }
				queue.push(cur.right);
				nextLevel++;
			}
		}
		if(curLevel == 0) {
			level++;
			curLevel = nextLevel;
			nextLevel = 0;
			if(curLevel != Math.pow(2,level)) {
				return false;
			}
		}
	}
	return true;
}
