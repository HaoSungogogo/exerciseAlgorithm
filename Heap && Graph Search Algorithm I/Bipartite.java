/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    Map<GraphNode, Integer> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!bfs(node, map)) {
        return false;
      }
    }
    return true;
  }
  private boolean bfs(GraphNode node, Map<GraphNode, Integer> map) {
    if (map.containsKey(node)) {
      return true;
    }
    Queue<GraphNode> qu = new LinkedList<>();
    qu.offer(node);
    map.put(node, 0);
    while (!qu.isEmpty()) {
      GraphNode curNode = qu.poll();
      int cur = map.get(curNode);
      int neinum = cur == 0 ? 1 : 0;
      for(GraphNode nei : curNode.neighbors) {
        if (!map.containsKey(nei)) {
          map.put(nei, neinum);
          qu.offer(nei);
        } else {
          if (map.get(nei) != neinum) {
            return false;
          }
        }
      }
    }
    return true;
  }
}

 
Using normal BFS graph search, and also use HashMap to record whether it has been traversed and 
the group that the node should belong