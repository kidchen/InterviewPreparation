// solution 1 : BFT
// use LinkedList to create a queue


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
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for(int i = 0; i < cur.neighbors.size(); i++) {
                // if the node is not created yet, create it
                if(!map.containsKey(cur.neighbors.get(i))) {
                    UndirectedGraphNode newCopy = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    map.put(cur.neighbors.get(i), newCopy);
                    queue.add(cur.neighbors.get(i));
                }
                // if node exist, just add this neighbor to the node's neighbor list
                // !!! this line will be executed anyway !!!
                // !!! Add map.get(), not just cur.neighbors.get(i) !!!
                map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
            }
        }
        return copy;
    }
}



// solution 2 : DFT
// use linkedList to create a stack


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

