package Graf.Library;


import Graf.Library.Interfaces.Edge;
import Graf.Library.Interfaces.Graph;

import java.util.*;

/**
 * 1. Пронумеруем все вершины графа
 * 2. Отметить все вершины графа, как новые
 * 3. Отметить все дуги графа, как новые
 * 4. Поместим произвольную вершину графа в стек
 * 5. Пока стек не пуст, прочитать (не выталкивая) из стека последнюю вершину
 * и применить к ней процедуру Find(Node V)
 * 6. Если стек пуст, но остались новые вершины, положить в стек любую из новых и перейти к п.5
 */

public class DirectedGraph implements Graph {

    List<Vertex> vertices;
    List<Edge> edges;

    public DirectedGraph() {
        vertices = new LinkedList<Vertex>();
        edges = new LinkedList<Edge>();
    }

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    @Override
    public void addEdge(Vertex fromVertex, Vertex toVertex) {
        Edge edge = createEdge(fromVertex, toVertex);
        if (!vertices.contains(fromVertex))
            vertices.add(fromVertex);
        if (!vertices.contains(toVertex))
            vertices.add(toVertex);

        edges.add(edge);
    }

    protected Edge createEdge(Vertex fromVertex, Vertex toVertex) {
        return new DirectEdge(fromVertex, toVertex);
    }

    @Override
    public List<Edge> getPath(Vertex fromVertex, Vertex toVertex) {
        if (!vertices.contains(fromVertex) || !vertices.contains(toVertex))
            return null;
        if (fromVertex.equals(toVertex))
            return new LinkedList<Edge>();

        Vertex currentVertex;
        Set<Vertex> neighbours;
        Map<Vertex, Edge> neighboursWithEdges;
        Stack<Vertex> edgesToCheckStack = new Stack<Vertex>();
        Set<Vertex> visitedVertices = new HashSet<Vertex>();
        Map<Vertex, List<Edge>> result = new HashMap<Vertex, List<Edge>>();

        edgesToCheckStack.push(fromVertex);

        do {
            currentVertex = edgesToCheckStack.pop();
            visitedVertices.add(currentVertex);

            neighboursWithEdges = getNeighboursWithEdges(currentVertex);
            neighbours = getNeighbours(neighboursWithEdges, visitedVertices);
            result.putAll(getPathsForNeighbours(neighbours, neighboursWithEdges, result));

            edgesToCheckStack.addAll(neighbours);

        } while (!edgesToCheckStack.empty() && !result.containsKey(toVertex));

        if (result.containsKey(toVertex))
            return result.get(toVertex);
        return null;
    }

    private Map<Vertex, List<Edge>> getPathsForNeighbours(Set<Vertex> neighbours,
                                                          Map<Vertex, Edge> neighboursWithEdges,
                                                          Map<Vertex, List<Edge>> currentPaths) {
        Map<Vertex, List<Edge>> result = new HashMap<Vertex, List<Edge>>();
        /**
         * !
         */
        for (Vertex vertex : neighbours) {
            List<Edge> pathToVertex = new LinkedList<Edge>();
            Edge edgeToAddIntoAPath = neighboursWithEdges.get(vertex);

            if (currentPaths.containsKey(edgeToAddIntoAPath.getLeadingVertex(vertex)))
                pathToVertex = new LinkedList<Edge>(currentPaths.get(
                        edgeToAddIntoAPath.getLeadingVertex(vertex)));

            pathToVertex.add(edgeToAddIntoAPath);

            result.put(vertex, pathToVertex);
        }
        return result;
    }

    private Set<Vertex> getNeighbours(Map<Vertex, Edge> neighboursWithEdges,
                                      Set<Vertex> visitedVertices) {
        Set<Vertex> neighbours = neighboursWithEdges.keySet();
        neighbours.removeAll(visitedVertices);
        return neighbours;
    }

    private Map<Vertex, Edge> getNeighboursWithEdges(Vertex currentVertex) {
        Map<Vertex, Edge> result = new HashMap<Vertex, Edge>();
        for (Edge edge : edges) {
            if (!edge.isLeadingVertex(currentVertex))
                continue;
            else
                result.put(edge.getSlaveVertex(currentVertex), edge);
        }
        return result;
    }
}
