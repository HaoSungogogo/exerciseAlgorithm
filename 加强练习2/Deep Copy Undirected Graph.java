/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    List<GraphNode> list = new ArrayList<>();
    if (graph == null) {
      return list;
    }
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        GraphNode newNode = new GraphNode(node.key);
        map.put(node, newNode);
        list.add(newNode);
        dfs(node, map, list);
      }
    }
    return list;
  }
  private void dfs(GraphNode node, Map<GraphNode, GraphNode> map, List<GraphNode> list) {
    GraphNode copy = map.get(node);
    for (GraphNode iter : node.neighbors) {
      if (!map.containsKey(iter)) {
        GraphNode newNeighbors = new GraphNode(iter.key);
        map.put(iter, newNeighbors);
        list.add(newNeighbors);
        dfs(iter, map, list);
      }
      copy.neighbors.add(map.get(iter));
    }
  }
}

Using dfs, k-nary tree.
Using adjacent array to represent Graph.


/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    List<GraphNode> list = new ArrayList<>();
    if (graph == null) {
      return list;
    }
    Map<GraphNode, GraphNode> map = new HashMap<>();
    Queue<GraphNode> qu = new LinkedList<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        GraphNode newNode = new GraphNode(node.key);
        map.put(node, newNode);
        list.add(newNode);
        qu.offer(node);
        while (!qu.isEmpty()) {
          int size = qu.size();
          for (int i = 0; i < size; i++) {
            GraphNode temp = qu.poll();
            for (GraphNode iter : temp.neighbors) {
              if (!map.containsKey(iter)) {
                GraphNode newNeighbor = new GraphNode(iter.key);
                map.put(iter, newNeighbor);
                list.add(newNeighbor);
                qu.offer(iter);
              }
              map.get(temp).neighbors.add(map.get(iter));
            }
          }
        }
      }
    }
    return list;
  }  
}

Using BFS1
