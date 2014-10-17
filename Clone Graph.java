// solution 1 : BFS
// use LinkedList to create a queue. O(n), O(n) space for the queue, hashmap and new nodes.


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(int i = 0; i < cur.neighbors.size(); i++) {
                // !!! if node not in map, add a new node into the map !!!
                if(!map.containsKey(cur.neighbors.get(i))) {
                    map.put(cur.neighbors.get(i), new UndirectedGraphNode(cur.neighbors.get(i).label));
                    queue.offer(cur.neighbors.get(i));
                }
                // now we are sure that the node is existed, add the neighbors to the value
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return map.get(node);
    }
}



// solution 2 : DFS
// use linkedList to create a stack(this is the only diff between BFS & DFS by iteration), O(n), O(n) space


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // BFS
        if(node == null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();
        stack.push(node);
        while(!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.poll();
            for(int i = 0; i < cur.neighbors.size(); i++) {
                if(!map.containsKey(cur.neighbors.get(i))) {
                    UndirectedGraphNode newCopy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i), newCopy);
                    stack.push(cur.neighbors.get(i));
                }
                // !!! Add map.get(), not just cur.neighbors.get(i) !!!
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return copy;
    }
}


// solution 3: DFS - recursion
// O(n), O(n) space cost

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        helper(node, map);
        return map.get(node);
    }
    
    private void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        for(int i = 0; i < node.neighbors.size(); i++) {
            UndirectedGraphNode cur = node.neighbors.get(i);
            if(!map.containsKey(cur)) {
                map.put(cur, new UndirectedGraphNode(cur.label));
                helper(cur, map);
            }
            map.get(node).neighbors.add(map.get(cur));
        }
    }
}

