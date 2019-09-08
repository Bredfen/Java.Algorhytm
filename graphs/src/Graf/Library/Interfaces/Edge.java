package Graf.Library.Interfaces;

import Graf.Library.Vertex;

public interface Edge {
    boolean isLeadingVertex(Vertex vertex);
    Vertex getSlaveVertex(Vertex leadingVertex);
    Vertex getLeadingVertex(Vertex slaveVertex);
}
