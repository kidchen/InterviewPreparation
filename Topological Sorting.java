/*
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A-->B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.
Note
You can assume that there is at least one topological order in the graph.
*/

// DFS: O(n) time with O(n) space for the map and the result

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
            return result;
        }
        // construct map with all nodes
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node: graph) {
            // mark 0 as unsorted
            map.put(node, 0);
        }
        // find a new unsorted node to start sorting (if possible):
        while (hasUnsorted(map, graph)) {
            DirectedGraphNode node = null;
            for (DirectedGraphNode temp : graph) {
                if (map.get(temp) == 0) {
                    node = temp;
                }
            }
            // get the node and do sort(search):
            sort(map, graph, result, node);
        }
        return result;
    }
    
    // check if there is any node that not yet been sorted
    public boolean hasUnsorted(Map<DirectedGraphNode, Integer> map, ArrayList<DirectedGraphNode> graph){
        for (DirectedGraphNode node : graph) {
            if (map.get(node) == 0) {
                return true;
            }
        }
        return false;
    }
    
    // search and sort the graph
    public void sort(Map<DirectedGraphNode, Integer> map, ArrayList<DirectedGraphNode> graph, ArrayList<DirectedGraphNode> result, DirectedGraphNode node){
        if (map.get(node) != 0) {
            // if 1: System.out.println("It is not a DAG");
            // if 2: sorted
            return;
        }
        // mark 1 as visited(not yet been sorted), do with its neighbors:
        map.put(node, 1);
        for (DirectedGraphNode next : node.neighbors) {
            sort(map, graph, result, next);
        }
        // mark 2 as sorted
        // map.put(node, 2);
        result.add(0, node);
    }
}
