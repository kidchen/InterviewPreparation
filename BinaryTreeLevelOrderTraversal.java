/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        helper(root, result, 1);
        return result;
    }
    
    void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
        // root.left and root.right are null
        if(root == null) return;
        // new level
        if(level>result.size()){
            result.add(new ArrayList<Integer>());
        }
        // add this node value (level is start from 1, so we need to "-1")
        result.get(level-1).add(root.val);
        helper(root.left,result,level+1);
        helper(root.right,result,level+1);
    }
}



// BFS:

public void levelOrder(TreeNode root) {
    if(root == null)
        return;
    // use a queue to store the parent nodes
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    // store the current level's nodes number
    int currentNum = 0;
    // store the last level's nodes number
    int lastNum = 1;
    ArrayList<Integer> list = new ArrayList<Integer>();
    while(!queue.isEmpty()) {
        TreeNode cur = queue.poll();
        lastNum--;
        list.add(cur.val);
        if(cur.left!=null) {
            queue.add(cur.left);
            currentNum++;
        }
        if(cur.right!=null) {
            queue.add(cur.right);
            currentNum++;
        }
        if(lastNum==0) {
            lastNum = currentNum;
            currentNum = 0;
            for(int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            list = new ArrayList<Integer>();
        }
    }
    return;
}
