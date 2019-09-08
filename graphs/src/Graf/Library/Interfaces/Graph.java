package Graf.Library.Interfaces;

import Graf.Library.Vertex;

import java.util.List;

public interface Graph {

    void addVertex(Vertex vertex);
    void addEdge(Vertex fromVertex, Vertex toVertex);
    List<Edge> getPath(Vertex fromVertex, Vertex toVertex);

}
