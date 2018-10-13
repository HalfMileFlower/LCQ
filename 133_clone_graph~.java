/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

 // BFS Solution - Brutal Force
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        ArrayList<UndirectedGraphNode> allNodes = findAllNodes(node);
        
        Map<UndirectedGraphNode, UndirectedGraphNode> originToNew = new HashMap<>();
        for (UndirectedGraphNode originNode : allNodes) {
            originToNew.put(originNode, new UndirectedGraphNode(originNode.label));
        }
        
        for (UndirectedGraphNode n : allNodes) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = originToNew.get(neighbor);
                originToNew.get(n).neighbors.add(newNeighbor);
            }
        }
        return originToNew.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> findAllNodes(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> result = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        queue.offer(node);
        visited.put(node, true);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode current = queue.poll();
                result.add(current);
                for (UndirectedGraphNode neighbor : current.neighbors) {
                    if (visited.containsKey(neighbor)) {
                        continue;
                    } else {
                        queue.offer(neighbor);
                        visited.put(neighbor, true);
                    }
                }
            }
        }
        return result;
    }
    
}

// Notes: first find all nodes with bfs, then copy nodes, then copy edges
// Use map to store originan and cloned nodes
// TC: O(n^2) worst SC: O(n) n is the number of nodes

// BFS Solution - find and clone at the same time

// DFS Solution