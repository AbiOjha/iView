package bigo;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ojha
 * Date: 6/16/13
 * Time: 12:05 AM
 */
public class Graph {

    protected Map<String, List<String>> adjacencyMap;

    public Graph(int size) {
        adjacencyMap = new HashMap<String, List<String>>(size);
    }

    public boolean addVertex(String vertex) {
        if (adjacencyMap.containsKey(vertex))
            return false;
        adjacencyMap.put(vertex, new ArrayList<String>());
        return true;
    }

    public boolean addEdge(String vertexStart, String vertexEnd) {
        addVertex(vertexStart);
        addVertex(vertexEnd);

        List<String> list = adjacencyMap.get(vertexStart);
        list.add(vertexEnd);
        return true;
    }

    public int getVerticesCount() {
        return adjacencyMap.size();
    }

    public int getEdgeCount() {
        int count = 0;
        Set<String> keys = adjacencyMap.keySet();

        for (String key : keys) {
            if (key != null) {
                List<String> edges = adjacencyMap.get(key);
                count += edges.size();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge("NY", "LONDON");
        g.addEdge("LA", "NY");
        g.addEdge("LA", "LONDON");
        g.addEdge("LA", "PARIS");
        g.addEdge("LONDON", "SYDNEY");
        g.addEdge("PARIS", "LA");
        g.addEdge("SYDNEY", "LA");

        System.out.println("No of vertices  = " + g.getVerticesCount());
        System.out.println("No of edges = " + g.getEdgeCount());
    }
}
