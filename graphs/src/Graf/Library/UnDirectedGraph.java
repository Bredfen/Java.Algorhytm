package Graf.Library;

import Graf.Library.Interfaces.Edge;

public class UnDirectedGraph extends DirectedGraph {

    @Override
    protected Edge createEdge(Vertex fromVertex, Vertex toVertex) {

        return new UnDirectedEdge(fromVertex, toVertex);
    }

}
